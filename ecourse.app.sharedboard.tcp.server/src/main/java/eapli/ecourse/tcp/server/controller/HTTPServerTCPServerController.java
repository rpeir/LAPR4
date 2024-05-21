package eapli.ecourse.tcp.server.controller;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.sharedBoardManagement.application.ShareBoardController;
import eapli.ecourse.tcp.infrastructure.MessageTCP;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class HTTPServerTCPServerController extends BaseTCPServerController<ShareBoardController>{
    public HTTPServerTCPServerController(ShareBoardController controller) {
        super(controller);
    }

    public HTTPServerTCPServerController() {
        super(new ShareBoardController());
    }

    public byte[] getBoard(String title, MessageTCP message) throws IOException, IllegalAccessException {
        if(!sessionManager.isValidSession(message.sessionID())){
            throw new IllegalArgumentException("Invalid session");
        }
        Board board = controller.getBoardByTitle(title, sessionManager.getUsername(message.sessionID()));
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(board);
        return os.toByteArray();
    }

    public String getBoards(MessageTCP message) {
        if(!sessionManager.isValidSession(message.sessionID())){
            throw new IllegalArgumentException("Invalid session");
        }
        List<Board> boards = controller.listUserReadBoardsShared(sessionManager.getUsername(message.sessionID()));
        if (boards.isEmpty()) throw new IllegalArgumentException("User has no boards");
        StringBuilder sb = new StringBuilder();
        for (Board board : boards) {
            sb.append(board.board_title());
            sb.append("\0");
        }
        return sb.toString();
    }
}
