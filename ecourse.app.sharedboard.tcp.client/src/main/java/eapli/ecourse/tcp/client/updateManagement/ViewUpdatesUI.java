package eapli.ecourse.tcp.client.updateManagement;

import eapli.ecourse.boardUpdate.dto.UpdateDTO;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.presentation.console.SelectWidget;

import java.net.Socket;
import java.util.List;

public class ViewUpdatesUI extends AbstractUI {
    private final ViewUpdatesTCPClientController controller;
    private Iterable<String>boards;
    public ViewUpdatesUI(Socket socket){
        controller=new ViewUpdatesTCPClientController(socket);
    }
    @Override
    protected boolean doShow() {
        try{
            boards= controller.listUserBoards();
            SelectWidget<String> board = new SelectWidget<>("Select the board to view the updates:", boards);
            board.show();
            if (board.selectedOption()==0) return false;
            String selectedBoard=board.selectedElement();
            List<UpdateDTO> updates = controller.listBoardHistory(selectedBoard);
            ListWidget<UpdateDTO> listWidget=new ListWidget<>("\nUpdate history of board "+selectedBoard, updates, new UpdateDTOPrinter());
            listWidget.show();
        }catch (Exception e){
            System.out.println("There was an error while retrieving the updates:");
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public String headline() {
        return "View Board Updates";
    }
}
