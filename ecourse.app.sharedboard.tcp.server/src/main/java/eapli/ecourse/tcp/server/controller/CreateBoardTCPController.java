package eapli.ecourse.tcp.server.controller;

import eapli.ecourse.boardManagement.application.CreateBoardController;
import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.tcp.infrastructure.MessageTCP;

public class CreateBoardTCPController extends BaseTCPServerController<CreateBoardController> {
    public CreateBoardTCPController(CreateBoardController controller) {
        super(controller);
    }

    public CreateBoardTCPController() {
        super(new CreateBoardController());
    }


    public void createBoard(MessageTCP message) {
        if(!sessionManager.isValidSession(message.sessionID())){
            throw new IllegalArgumentException("Invalid session");
        }
        try {
            String title = new String(message.data());
            Board board = controller.createBoard(title,sessionManager.getUsername(message.sessionID()));
            controller.defineSharedBoardPermisssions(board);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
