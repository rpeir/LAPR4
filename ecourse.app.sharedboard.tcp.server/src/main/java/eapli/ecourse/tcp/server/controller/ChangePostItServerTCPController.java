package eapli.ecourse.tcp.server.controller;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.postit.application.ChangePostItController;
import eapli.ecourse.tcp.infrastructure.MessageTCP;

public class ChangePostItServerTCPController extends BaseTCPServerController<ChangePostItController>{
    public ChangePostItServerTCPController(ChangePostItController controller) {
        super(controller);
    }
    public ChangePostItServerTCPController() {
        super(new ChangePostItController());
    }

    public String listBoardsWithWritePermission(MessageTCP message) {
        if(!sessionManager.isValidSession(message.sessionID())){
            throw new IllegalArgumentException("Invalid session");
        }
        Iterable<Board> boards = this.controller.listBoardsWithWritePermission(sessionManager.getUsername(message.sessionID()));
        StringBuilder sb = new StringBuilder();
        for (Board board : boards) {
            sb.append(board.board_title());
            sb.append("\0");
        }
        return sb.toString();
    }
    public void changePostIt(String boardTitle, int row, int column, String contentType, byte[] content,MessageTCP message) {
        if(!sessionManager.isValidSession(message.sessionID())){
            throw new IllegalArgumentException("Invalid session");
        }
        this.controller.changePostIt(sessionManager.getUsername(message.sessionID()), boardTitle, row, column, contentType, content);
    }

    public void movePostIt(String boardTitle3, int row1, int column1, int row2, int column2,MessageTCP message ) {
        if(!sessionManager.isValidSession(message.sessionID())){
            throw new IllegalArgumentException("Invalid session");
        }
        try {
            this.controller.movePostIt(sessionManager.getUsername(message.sessionID()), boardTitle3, row1, column1, row2, column2);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void deletePostIt(String boardTitle, int row, int column,MessageTCP message) {
        if(!sessionManager.isValidSession(message.sessionID())){
            throw new IllegalArgumentException("Invalid session");
        }
        try {
            this.controller.deletePostIt(sessionManager.getUsername(message.sessionID()), boardTitle, row, column);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
