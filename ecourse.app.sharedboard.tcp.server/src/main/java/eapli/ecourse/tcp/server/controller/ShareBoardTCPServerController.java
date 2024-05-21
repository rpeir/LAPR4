package eapli.ecourse.tcp.server.controller;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.sharedBoardManagement.application.ShareBoardController;
import eapli.ecourse.sharedBoardManagement.domain.UserPermission;
import eapli.ecourse.tcp.infrastructure.MessageTCP;

import java.util.List;

public class ShareBoardTCPServerController extends BaseTCPServerController<ShareBoardController>{

    public ShareBoardTCPServerController() {
        super(new ShareBoardController());
    }

    public ShareBoardTCPServerController(ShareBoardController controller) {
        super(controller);
    }

    public String listActiveBoards(MessageTCP message) {
        if(!sessionManager.isValidSession(message.sessionID())){
            throw new IllegalArgumentException("Invalid session");
        }
        List<Board> boards = (List<Board>) controller.listActiveBoards(sessionManager.getUsername(message.sessionID()));
        StringBuilder sb = new StringBuilder();
        for (Board board : boards) {
            sb.append(board.board_title());
            sb.append("\0");
        }
        return sb.toString();
    }

    public String getPermissions(MessageTCP message) {
        if(!sessionManager.isValidSession(message.sessionID())){
            throw new IllegalArgumentException("Invalid session");
        }
        List<UserPermission> permissions = controller.getPermissions();
        StringBuilder sb = new StringBuilder();
        for (UserPermission permission : permissions) {
            sb.append(permission.toString());
            sb.append("\0");
        }
        return sb.toString();
    }

    public void shareBoard(MessageTCP message) {
        if(!sessionManager.isValidSession(message.sessionID())){
            throw new IllegalArgumentException("Invalid session");
        }
        String[] data = new String(message.data()).split("\0");
        if (data.length != 3) throw new IllegalArgumentException("TCP message not received correctly");
        try {
            controller.shareBoard(data[0], data[1], data[2]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
