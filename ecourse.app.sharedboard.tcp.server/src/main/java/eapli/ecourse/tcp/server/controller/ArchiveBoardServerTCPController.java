package eapli.ecourse.tcp.server.controller;

import eapli.ecourse.boardManagement.application.ArchiveBoardController;
import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.tcp.infrastructure.MessageTCP;

public class ArchiveBoardServerTCPController extends BaseTCPServerController<ArchiveBoardController> {
    public ArchiveBoardServerTCPController(ArchiveBoardController controller) {
        super(controller);
    }

    public ArchiveBoardServerTCPController() {
        super(new ArchiveBoardController());
    }

    public String listActiveBoards(MessageTCP message) {
        if(!sessionManager.isValidSession(message.sessionID())){
            throw new IllegalArgumentException("Invalid session");
        }
        Iterable<Board> boards = controller.listActiveBoards(sessionManager.getUsername(message.sessionID()));
        StringBuilder builder = new StringBuilder();
        for (Board b : boards) {
            builder.append(b.board_title());
            builder.append("\0");
        }
        return builder.toString();
    }

    public void archiveBoard(MessageTCP message) {
        if(!sessionManager.isValidSession(message.sessionID())){
           throw new IllegalArgumentException("Invalid session");
        }
        try {
            controller.archiveBoard(new String(message.data()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException((e.getMessage()));
        }
    }
}
