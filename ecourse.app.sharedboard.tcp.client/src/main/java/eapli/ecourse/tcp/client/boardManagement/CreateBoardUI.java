package eapli.ecourse.tcp.client.boardManagement;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.net.Socket;

public class CreateBoardUI extends AbstractUI {
    private final CreateBoardTCPClientController theController;
    public CreateBoardUI(Socket socket) {
        theController = new CreateBoardTCPClientController(socket);
    }

    @Override
    protected boolean doShow() {
        try {
            String board_title= Console.readNonEmptyLine("Board title:", "Board title should not be empty").trim();
            theController.createBoard(board_title);
            System.out.println("Board created with success!");
            return true;
        } catch (Exception e) {
            System.out.println("Error creating the board!");
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Create Board";
    }
}
