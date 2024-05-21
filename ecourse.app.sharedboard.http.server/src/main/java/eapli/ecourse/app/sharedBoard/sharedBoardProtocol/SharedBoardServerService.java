package eapli.ecourse.app.sharedBoard.sharedBoardProtocol;


import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.postit.domain.Content;
import eapli.ecourse.postit.domain.PostIt;
import eapli.ecourse.tcp.infrastructure.MessageFormatTCP;


import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 * The type Shared board server service.
 */
public class SharedBoardServerService {

    private final SharedBoardTCPController tcpController;

    private final String BASEDIR;

    public SharedBoardServerService(MessageFormatTCP mf, String basedir) {
        tcpController = new SharedBoardTCPController(mf);
        BASEDIR = basedir;
    }

    /**
     * Authenticate user
     * @param email user email
     * @param password user password
     * @return user token session id, if the user is authenticated, exception otherwise
     */
    public long authenticateUser(final String email, final String password) {
        return tcpController.authenticate(email + "\0" + password);
    }
    public void logout(long token) throws IOException {
        tcpController.logout(token);
    }


    /**
     * Gets the intitial CSS of the global page, and the list of boards of the user, in HTML format
     * @param token user token session id
     * @return the HTML in string format
     */
    public String getBoards(long token) throws IOException, ClassNotFoundException {
        StringBuilder textHtml;
        List<String> boards = tcpController.getBoards(token);
        textHtml = new StringBuilder();
        textHtml.append("<title>Shared Board</title>");
        textHtml.append("<script> var sessionToken = '").append(token).append("'; </script>");
        textHtml.append("<style>\n" +
                "    table {\n" +
                "        border-collapse: collapse;\n" +
                "        width: 100%;\n" +
                "        font-family: Arial, sans-serif;\n" +
                "    }\n" +
                "\n" +
                "    td,\n" +
                "    th {\n" +
                "        border: 1px solid #000;\n" +
                "        padding: 8px;\n" +
                "        text-align: left;\n" +
                "    }\n" +
                "\n" +
                "    th {\n" +
                "        background-color: #f2f2f2;\n" +
                "    }\n" +
                "\n" +
                "    ul {\n" +
                "        list-style-type: none;\n" +
                "        margin: 0;\n" +
                "        padding: 0;\n" +
                "    }\n" +
                "\n" +
                "    #boardList li {\n" +
                "        display: inline-block;\n" +
                "        margin-right: 10px;\n" +
                "    }\n" +
                "\n" +
                "    #boardList button {\n" +
                "        padding: 5px 10px;\n" +
                "        border: none;\n" +
                "        background-color: #f2f2f2;\n" +
                "        cursor: pointer;\n" +
                "    }\n" +
                "\n" +
                "    #board {\n" +
                "        margin-top: 20px;\n" +
                "        padding: 10px;\n" +
                "        border: 1px solid #000;\n" +
                "        background-color: #f2f2f2;\n" +
                "    }\n" +
                "    p {\n" +
                "        text-align: center;\n" +
                "        font-weight: bold;\n" +
                "    }\n" +
                "    .container {\n" +
                "        display: flex;\n" +
                "        justify-content: center;\n" +
                "        align-items: center;\n" +
                "        margin-top: 20px;\n" +
                "    }\n" +
                "    .disconnect-button {\n" +
                "        padding: 10px 20px;\n" +
                "        border: none;\n" +
                "        background-color: #ff0000;\n" +
                "        cursor: pointer;\n" +
                "    }\n" +
                "</style>");
        textHtml.append("<ul>");
        textHtml.append("<p style=\"font-family: Arial, sans-serif;\">Available boards:</p>");
        textHtml.append("<div id=\"boardList\">");
        // Adding disconnect button
        //textHtml.append("<button type=button onclick=\"disconnect()\">Disconnect</button>");
        for (String b : boards) {
            textHtml.append("<li><button type=button onclick=\"viewBoard('").append(b)
                    .append("')\">").append(b).append("</button>").append("</li>");
        }
        textHtml.append("<script src=\"auth.js\"></script>");
        textHtml.append("</div>");
        textHtml.append("<div id=\"board\" style=\"font-family: Arial, sans-serif;\">\nSelect a board ...\n</div>");
        textHtml.append("<div class=\"container\">\n");
        textHtml.append("<button class=\"disconnect-button\" type=\"button\" onclick=\"disconnect()\">Disconnect</button>\n");
        textHtml.append("</div>\n");
        textHtml.append("</ul>");
        return textHtml.toString();
    }


    /**
     * View board in HTML table format.
     * @param boardTitle board title of the board to render
     * @param token user token session id
     * @return HTML table, in string format
     */
    public String viewBoardHtml(String boardTitle, long token) {
        StringBuilder textHtml;
        try {
            Board board = tcpController.getBoard(boardTitle, token);
            return generateTableFromBoard(board);
        } catch (Exception e) {
            textHtml = new StringBuilder("<label>");
            textHtml.append(e.getMessage());
            textHtml.append("</label>");
        }
        return textHtml.toString();
    }

    /**
     * Generate HTML table from board.
     * @param board board to render
     * @return HTML table, in string format
     */
    private String generateTableFromBoard(Board board) {
        StringBuilder htmlBuilder = new StringBuilder();

        htmlBuilder.append("<!DOCTYPE html>");
        htmlBuilder.append("<html>");
        htmlBuilder.append("<head>");
        htmlBuilder.append("<meta charset=\"UTF-8\">");
        htmlBuilder.append("<style>");
        htmlBuilder.append(".table-container {");
        htmlBuilder.append("max-width: 2000px;"); // Set the maximum width here
        htmlBuilder.append("margin: 0 auto;"); // Center the table horizontally
        htmlBuilder.append("}");

        htmlBuilder.append("table {");
        htmlBuilder.append("width: 100%;");
        htmlBuilder.append("border-collapse: collapse;");
        htmlBuilder.append("table-layout: fixed;"); // Added table-layout: fixed
        htmlBuilder.append("}");

        htmlBuilder.append("th, td {");
        htmlBuilder.append("text-align: center;");
        htmlBuilder.append("border: 1px solid grey;");
        htmlBuilder.append("max-width: 100px");
        htmlBuilder.append("max-height: 100px;");
        htmlBuilder.append("overflow: auto;");
        htmlBuilder.append("text-overflow: clip;");
        htmlBuilder.append("}");

        htmlBuilder.append("th {");
        htmlBuilder.append("width: 10%;");
        htmlBuilder.append("}");

        htmlBuilder.append("td {");
        htmlBuilder.append("width: calc(90% / ").append(board.getNumberOfColumns()).append(");"); // Adjusted width calculation
        htmlBuilder.append("height: 10%;");
        htmlBuilder.append("}");

        htmlBuilder.append("img {");
        htmlBuilder.append("max-width: 100%;");
        htmlBuilder.append("max-height: 100%;");
        htmlBuilder.append("}");
        htmlBuilder.append("</style>");
        htmlBuilder.append("</head>");
        htmlBuilder.append("<body>");
        htmlBuilder.append("<div class=\"table-container\">");
        htmlBuilder.append("<table>");
        htmlBuilder.append("<thead>");
        htmlBuilder.append("<caption style=\"font-family: Arial, sans-serif;\">").append(board.board_title()).append(board.isActive()?"":" - ARCHIVED").append("</caption>");
        htmlBuilder.append("<tr>");
        htmlBuilder.append("<th></th>");
        for (int i = 1; i <= board.getNumberOfColumns(); i++) {
            htmlBuilder.append("<th>Column ").append(i).append("</th>");
        }
        htmlBuilder.append("</tr>");
        htmlBuilder.append("</thead>");

        htmlBuilder.append("<tbody>");
        for (int i = 1; i <= board.getNumberOfRows(); i++) {
            htmlBuilder.append("<tr>");
            htmlBuilder.append("<th>Row ").append(i).append("</th>");
            for (int j = 1; j <= board.getNumberOfColumns(); j++) {
                PostIt postIt = board.getPostIt(i, j);
                if (postIt != null) {
                    htmlBuilder.append("<td style=\"background-color:#98FB98;\">"); // Green color for Post-It
                    Content content = postIt.content();
                    switch (content.type()) {
                        case TEXT:
                            htmlBuilder.append((String) content.getContent(""));
                            break;
                        case IMAGE:
                            File image = (File) content.getContent(BASEDIR + "/" + board.board_title() + "-post-" + i + "-" + j + ".png");
                            htmlBuilder.append("<div class=\"image-container\">");
                            htmlBuilder.append("<img src=\"").append(image.getName()).append("\" alt=\"Image\">");
                            htmlBuilder.append("</div>");
                            break;
                    }
                    htmlBuilder.append("</td>");
                } else {
                    //if column number is even
                    if (j % 2 == 0)
                        htmlBuilder.append("<td style=\"background-color:##adadad;\"></td>");
                    else
                        htmlBuilder.append("<td style=\"background-color:#e0e0e0;\"></td>");
                }
            }
            htmlBuilder.append("</tr>");
        }
        htmlBuilder.append("</tbody>");

        htmlBuilder.append("</table>");
        htmlBuilder.append("</div>");
        htmlBuilder.append("</body>");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
    }



}
