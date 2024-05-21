package eapli.ecourse.tcp.client.postit;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.presentation.console.SelectWidget;

import java.net.Socket;

/**
 * User interface for undo last change post-it use case
 */
public class UndoLastChangePostItUI extends AbstractUI {

    private final UndoLastChangePostItTCPClientController controller;
    public UndoLastChangePostItUI(Socket sock) {
        controller = new UndoLastChangePostItTCPClientController(sock);
    }

    public UndoLastChangePostItUI(UndoLastChangePostItTCPClientController controller) {
        this.controller = controller;
    }

    @Override
    protected boolean doShow() {
        try {
            SelectWidget<String> boards = new SelectWidget<>("Select one of the boards:", controller.listAvailableBoards());
            boards.show();
            if (boards.selectedOption() == 0) return false;
            System.out.println("Select post-it to undo last change");
            int row = Console.readInteger("Insert the line: ");
            int column = Console.readInteger("Insert the column: ");
            controller.undoLastChangePostIt(boards.selectedElement(), row, column);
            System.out.println("Undo successful");
            return true;
        } catch (Exception e) {
            System.out.println("Error undoing last change");
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public String headline() {
        return "Undo Last Change Post-It";
    }
}
