package eapli.ecourse.tcp.client;

import eapli.ecourse.tcp.client.boardManagement.ArchiveBoardUI;
import eapli.ecourse.tcp.client.boardManagement.CreateBoardUI;
import eapli.ecourse.tcp.client.postit.ChangePostItUI;
import eapli.ecourse.tcp.client.postit.CreatePostItUI;
import eapli.ecourse.tcp.client.postit.UndoLastChangePostItUI;
import eapli.ecourse.tcp.client.updateManagement.ViewUpdatesUI;
import eapli.ecourse.tcp.client.shareBoardManagement.ShareBoardUI;
import eapli.ecourse.tcp.infrastructure.MessageCodesTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MainMenuUI {
    private Socket sock;
    private DefaultTCPController theController;

    /**
     * Instantiates a new Main menu ui.
     * @param sockp the sockp
     */
    public MainMenuUI(final Socket sockp) {
        this.sock = sockp;
        this.theController = new DefaultTCPController(sockp);
    }

    /**
     * Handle ack.
     * @param codeResult the code result
     * @param messageOK  the message ok
     * @param messageBAD the message bad
     */
    public void handleACK(final int codeResult,
                          final String messageOK,
                          final String messageBAD) {
        if (codeResult == MessageCodesTCP.ACK) {
            System.out.println(messageOK);
        } else {
            System.out.println(messageBAD);
        }
    }

    /**
     * Do show.
     * @throws IOException the io exception
     */
    public void doShow() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        int choice = 0, codeResult;


        System.out.println("Please authenticate to continue:");
        LoginUI loginUI = new LoginUI(theController);
        loginUI.doShow();


        do {
            System.out.println("1 - Communication test");
            System.out.println("2 - Share a Board");
            System.out.println("3 - Archive a Board");
            System.out.println("4 - Create Board");
            System.out.println("5 - View Updates");
            System.out.println("6 - Create Post-It");
            System.out.println("7 - Change Post-It");
            System.out.println("8 - Undo Last Change Post-It");
            System.out.println("0 - End of session request");
            System.out.println("\nOption - ");
            try {
                input = in.readLine();
                choice = Integer.parseInt(input);
            } catch(NumberFormatException ex) {
                choice = 0;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            switch (choice) {
                case 1:
                    codeResult = theController.sendCommunicationTest();

                    handleACK(codeResult,
                            "Communication test with success!\n",
                            "Problem with communication test!\n");

                    break;
                case 2:
                    new ShareBoardUI(sock).show();
                    break;
                case 3:
                    new ArchiveBoardUI(sock).show();
                    break;
                case 4:
                    new CreateBoardUI(sock).show();
                    break;
                case 5:
                    new ViewUpdatesUI(sock).show();
                    break;
                case  6:
                    new CreatePostItUI(sock).show();
                    break;
                case 7:
                    new ChangePostItUI(sock).show();
                    break;
                case 8:
                    new UndoLastChangePostItUI(sock).show();
                    break;
                case 0:
                    codeResult = theController.sendEndOfSession();

                    if(codeResult == MessageCodesTCP.ACK){
                        System.out.println("End of session request with success!\n");
                        choice = -1;
                    } else {
                        System.out.println("Problem with end of session request!\n");
                    }

                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        } while(choice != -1);

        sock.close();
    }
}
