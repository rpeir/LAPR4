package eapli.ecourse.tcp.client.shareBoardManagement;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.net.Socket;
import java.util.List;

public class ShareBoardUI extends AbstractUI {
    private final ShareBoardTCPClientController theController;

    public ShareBoardUI(Socket socket) {
        this.theController = new ShareBoardTCPClientController(socket);
    }
    @Override
    protected boolean doShow() {
        try {
            List<String> boards= theController.listActiveBoards();
            SelectWidget<String> board = new SelectWidget<>("Select the board to share:", boards);
            board.show();
            if (board.selectedOption() == 0) return true;
            String selectedBoard = board.selectedElement();
            EmailAddress email=EmailAddress.valueOf(Console.readLine("Email of the user to share the board:"));
            SelectWidget<String> permission = new SelectWidget<>("Select the permission to share the board:", theController.getPermissions());
            permission.show();
            if (permission.selectedOption() == 0) return true;
            String userPermission=permission.selectedElement();
            theController.shareBoard(selectedBoard,email,userPermission);
            System.out.println("Board shared with success!");
        } catch (Exception e) {
            System.out.println("Error sharing board!");
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public String headline() {
        return "Share Board";
    }

}
