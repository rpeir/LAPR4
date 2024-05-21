package eapli.ecourse.app.sharedBoard;

import eapli.ecourse.tcp.infrastructure.MessageFormatTCP;
import eapli.framework.io.util.Console;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class HttpSharedBoardServerApp {
    static private final String BASE_FOLDER = "ecourse.app.sharedboard.http.server/src/main/java/eapli/ecourse/app/sharedBoard/www";
    static private ServerSocket sock;
    static private Socket tcpSock;

    static private final int HTTP_PORT = 8080;
    static private final int TCP_PORT = 9999;

    public static void main(String args[]) {
        Socket cliSock;
        String tcpServerIP = null;
        if (args.length == 0) {
            tcpServerIP = Console.readNonEmptyLine("TCP Server IP Address: ", "TCP Server IP Address must not be empty");
        } else if (args.length == 1) {
            tcpServerIP = args[0];
        } else  {
            System.out.println("Usage: HttpSharedBoardServer [tcpServerIP]");
            System.exit(1);
        }

        accessesCounter = 0;

        try {
            sock = new ServerSocket(HTTP_PORT);
        } catch (IOException ex) {
            System.out.println("Server failed to open local port " + HTTP_PORT);
            System.exit(1);
        }

        try {
            InetAddress ipAddress = InetAddress.getLocalHost();
            String ipAddr = ipAddress.getHostAddress();
            System.out.println("Server IP Address: " + ipAddr  + " Port: " + HTTP_PORT);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            InetAddress tcpIpAddress = InetAddress.getByName(tcpServerIP);
            tcpSock = new Socket(tcpIpAddress, TCP_PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }


        MessageFormatTCP mf = new MessageFormatTCP(tcpSock);
        while (true) {
            try {
                cliSock = sock.accept();
                HttpSharedBoardRequest req = new HttpSharedBoardRequest(cliSock, mf, BASE_FOLDER);
                req.start();
                incAccessesCounter();
            } catch (IOException ex) {
                System.out.println("Failed to accept client connection.");
                ex.printStackTrace();
            }
        }
    }

    // DATA ACCESSED BY THREADS - LOCKING REQUIRED
    private static int accessesCounter;

    private static synchronized void incAccessesCounter() {
        accessesCounter++;
    }

}
