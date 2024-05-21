package eapli.ecourse.tcp.client;

import eapli.framework.io.util.Console;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.UUID;

public class TcpSharedBoardClientApp {
    private static InetAddress serverIP;
    private static Socket sock;
    private static final int PORT = 9999;
    public static long sessionID;

    /**
     * Main.
     *
     * @param args the args
     * @throws Exception the exception
     */
    public static void main(String args[]) throws Exception {
        /*
        if (args.length != 1) {
            System.out.println("Server IPv4/IPv6 address "
                    + "or DNS name is required as argument");
            System.exit(1);
        }

        try {
            serverIP = InetAddress.getByName(args[0]);
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server specified: " + args[0]);
            System.exit(1);
        }

        try {
            sock = new Socket(serverIP, PORT);
        } catch (IOException ex) {
            System.out.println("Failed to establish TCP connection");
            System.exit(1);
        }

        MainMenuUI ui = new MainMenuUI(sock);
        ui.doShow();
    }

         */
        try {
            String serverIP;
            if (args.length == 1) {
                serverIP = args[0];
            } else {
                serverIP = Console.readLine("Enter IP address of server: ");
            }
            sock = new Socket(serverIP, PORT);
        } catch (IOException ex) {
            System.out.println("Failed to establish TCP connection");
            System.exit(1);
        }
        MainMenuUI ui = new MainMenuUI(sock);
        ui.doShow();
    }
}