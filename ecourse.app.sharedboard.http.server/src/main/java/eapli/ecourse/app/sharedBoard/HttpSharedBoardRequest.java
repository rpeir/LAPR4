package eapli.ecourse.app.sharedBoard;

import eapli.ecourse.app.sharedBoard.common.HTTPmessage;
import eapli.ecourse.app.sharedBoard.sharedBoardProtocol.SharedBoardServerService;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.tcp.infrastructure.MessageFormatTCP;
import eapli.ecourse.usermanagement.domain.ECoursePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpSharedBoardRequest extends Thread {
    String baseFolder;
    Socket sock;
    private final SharedBoardServerService service;

    public HttpSharedBoardRequest(Socket s, MessageFormatTCP mf, String f) {
        baseFolder = f;
        sock = s;
        service = new SharedBoardServerService(mf, f);
    }

    public void run() {

        try {
            HTTPmessage request = new HTTPmessage(new DataInputStream(sock.getInputStream()));
            HTTPmessage response = new HTTPmessage();

            String uri =request.getURI();
            String[] words = request.getURI().split("/");
            if (words.length >= 3 && (words[1].equals("board") || words[1].equals("disconnect"))){
                uri = words[1];
            }

            switch (request.getMethod()) {
                case "GET":
                    switch (uri) {
                        case "/":
                            String fullname = baseFolder + "/auth.html";
                            if (response.setContentFromFile(fullname)) {
                                response.setResponseStatus("Ok");
                                response.setURI("/login");
                            } else {
                                fileNotFound(response);
                            }
                            break;
                        case "board":
                            String msg = service.viewBoardHtml(words[2], Long.parseLong(words[3]));
                            response.setContent(msg, "text/html");
                            response.setResponseStatus("200");
                            response.setURI("/board");
                            break;
                        default:
                            fullname = baseFolder + "/" + request.getURI();
                            if (response.setContentFromFile(fullname)) {
                                response.setResponseStatus("Ok");
                            } else {
                                fileNotFound(response);
                            }
                    }
                    break;
                case "POST":
                    switch (uri) {
                        case "/login":
                            String[] credentials = credentials(request);
                            try {
                                long token = service.authenticateUser(credentials[0], credentials[1]);
                                response.setContent(service.getBoards(token), "text/html");
                                response.setURI("/"+String.valueOf(token));
                                response.setResponseStatus("200");
                            } catch (IllegalArgumentException e) {
                                //response.setContentFromString(
                                  //      "<html><body><label>"+e.getMessage()+ "</label></body></html>",
                                    //    "text/html");
                                //response.setResponseStatus("500 Server Error");
                                response.setContentFromString(
                                        "<html>\n" +
                                                "<head>\n" +
                                                "  <title>Error</title>\n" +
                                                "  <style>\n" +
                                                "    body {\n" +
                                                "      background-color: #f2f2f2;\n" +
                                                "      font-family: Arial, sans-serif;\n" +
                                                "      display: flex;\n" +
                                                "      justify-content: center;\n" +
                                                "      align-items: center;\n" +
                                                "      height: 100vh;\n" +
                                                "      margin: 0;\n" +
                                                "    }\n" +
                                                "    .container {\n" +
                                                "      background-color: #e6e6e6;\n" +
                                                "      padding: 20px;\n" +
                                                "      border-radius: 8px;\n" +
                                                "      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\n" +
                                                "    }\n" +
                                                "    label {\n" +
                                                "      color: #ff0000;\n" +
                                                "      font-size: 18px;\n" +
                                                "      font-weight: bold;\n" +
                                                "      text-align: center;\n" +
                                                "    }\n" +
                                                "  </style>\n" +
                                                "</head>\n" +
                                                "<body>\n" +
                                                "  <div class='container'>\n" +
                                                "    <label>" + e.getMessage() + "</label>\n" +
                                                "  </div>\n" +
                                                "</body>\n" +
                                                "</html>",
                                        "text/html");
                                response.setResponseStatus("500 Server Error");
                            }
                            break;
                            case "disconnect":
                                try {
                                    service.logout(Long.parseLong(words[2]));
                                    response.setContentFromString("<html><head><style>body{background-color:#f2f2f2;font-family: Arial, sans-serif;display: flex; justify-content: center; align-items: center;" +
                                            "height: 100vh;margin:0;} .container{background-color: #e6e6e6; padding: 20px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);} .container label{color: #ff0000; font-size: 18px; font-weight: bold; text-align: center;} .container .thank-you{color: #000000;}</style></head><body><div class='container'><label>Disconnected Successfully.</label><br><label class='thank-you'>Thank you for using ECourse Shared Board Application!</label></div></body></html>","text/html");
                                    response.setResponseStatus("Disconnected");
                                }catch (IllegalArgumentException e){
                                    response.setContentFromString(
                                            "<html><body><label>Disconnect Error</label></body></html>",
                                            "text/html");
                                    response.setResponseStatus("Disconnect Error");
                                }
                                break;
                        default:
                            notImplemented(response);
                            break;
                    }
                    break;
            }
            response.send(new DataOutputStream(sock.getOutputStream()));
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Thread error when reading request");
            System.out.println(ex.getMessage());
        }

    }

    private void fileNotFound(HTTPmessage msg) {
        msg.setContentFromString(
                "<html><body><h1>404 File not found</h1></body></html>",
                "text/html");
        msg.setResponseStatus("404 Not Found");
        msg.setURI("/404");
    }

    private void notImplemented(HTTPmessage msg) {
        msg.setContentFromString(
                "<html><body><h1>501 Not Implemented</h1></body></html>",
                "text/html");
        msg.setResponseStatus("501 Not Implemented");
    }

    private String[] credentials(HTTPmessage msg) {
        String[] returns = new String[2];
        String[] contents = java.net.URLDecoder.decode(msg.getContentAsString(), StandardCharsets.UTF_8).split("&");
        for (String content : contents) {
            String[] parts = content.split("=");
            if (parts.length == 2) {
                if (parts[0].equals("username")) {
                    returns[0] = parts[1];
                } else if (parts[0].equals("password")) {
                    returns[1] = parts[1];
                }
            }
        }
        return returns;
    }

}
