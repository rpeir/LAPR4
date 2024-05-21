package eapli.ecourse.tcp.client;


import eapli.ecourse.tcp.infrastructure.MessageCodesTCP;
import eapli.ecourse.tcp.infrastructure.MessageTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class LoginUI {
    private BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in));
    private DefaultTCPController theController;

    /**
     * Instantiates a new Login ui.
     * @param theController the controller
     */
    public LoginUI(final DefaultTCPController theController) {
        this.theController = theController;
    }

    /**
     * Ask user Email and Password to authenticate.
     */
    protected void doShow() {
        try {
            boolean sucess;
            do {
                System.out.print("Email: ");
                String email = in.readLine();

                System.out.print("Password: ");
                String password = in.readLine();
                System.out.println();

                String data = email + "\0" + password + "\0";

                MessageTCP result = theController.authenticate(data);

                if (result.code() == MessageCodesTCP.ACK) {
                    TcpSharedBoardClientApp.sessionID = result.sessionID();
                    System.out.println("Session ID: " + TcpSharedBoardClientApp.sessionID);
                    System.out.println("User authenticated successfully!\n");
                    sucess = true;
                } else {
                    String errorData;

                    if (result.data().length > 0) {
                        errorData = new String(result.data(),
                                StandardCharsets.US_ASCII);
                    } else {
                        errorData = "Invalid credentials!";
                    }

                    System.out.println(errorData + "\n");
                    sucess = false;
                }
            } while (!sucess);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
