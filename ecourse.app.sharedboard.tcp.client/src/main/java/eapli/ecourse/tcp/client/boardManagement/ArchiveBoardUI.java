package eapli.ecourse.tcp.client.boardManagement;

import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.net.Socket;

public class ArchiveBoardUI extends AbstractUI {
    private final ArchiveBoardTCPClientController theController;
    private Iterable<String> ownedActiveBoards;
    public ArchiveBoardUI(Socket socket) {
        theController = new ArchiveBoardTCPClientController(socket);
    }

    @Override
    protected boolean doShow() {
        try {
            ownedActiveBoards=theController.listActiveBoards();
            SelectWidget<String>board= new SelectWidget<>("Select the board to archive:",ownedActiveBoards);
            board.show();
            String selectedBoard = board.selectedElement();
            if(selectedBoard==null) return false;

            theController.archiveBoard(selectedBoard);
            System.out.println("Board archived successfully!");
        }
        catch (Exception e){
            System.out.println("There was an error while archiving the board:");
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public String headline() {
        return "Archive Board";
    }
}
