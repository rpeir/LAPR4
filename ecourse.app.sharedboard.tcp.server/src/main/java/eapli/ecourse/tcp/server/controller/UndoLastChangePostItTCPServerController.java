package eapli.ecourse.tcp.server.controller;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.postit.application.UndoLastChangePostItController;
import eapli.ecourse.tcp.infrastructure.MessageFormatTCP;
import eapli.ecourse.tcp.infrastructure.MessageTCP;

import java.util.List;

/**
 * Controller to convert message TCP in a domain controller
 */
public class UndoLastChangePostItTCPServerController extends BaseTCPServerController<UndoLastChangePostItController> {
    public UndoLastChangePostItTCPServerController(UndoLastChangePostItController controller) {
        super(controller);
    }

    public UndoLastChangePostItTCPServerController() {
        super(new UndoLastChangePostItController());
    }

    /**
     * List the boards available to the user
     * @param msg message with the session id of the user
     * @return list of boards available to the user, in a string separated by \0
     */
    public String listAvailableBoards(MessageTCP msg) {
        if (!sessionManager.isValidSession(msg.sessionID())) throw new IllegalArgumentException("Invalid session");
        List<Board> boards = controller.listAvailableBoards(sessionManager.getUsername(msg.sessionID()));
        StringBuilder stringBuilder = new StringBuilder();
        for (Board board : boards) {
            stringBuilder.append(board.board_title()).append("\0");
        }
        return stringBuilder.toString();
    }

    /**
     * Undo the last change made to a postit
     * @param boardTitle title of the board where the postit is
     * @param row row of the postit
     * @param column column of the postit
     * @param sessionId session id of the user
     */
    public void undoLastChangePostIt(String boardTitle, int row, int column, long sessionId) {
        if (!sessionManager.isValidSession(sessionId))
            throw new IllegalArgumentException("Invalid session");
        controller.undoLastChangePostIt(sessionManager.getUsername(sessionId), boardTitle, row, column);
    }
}
