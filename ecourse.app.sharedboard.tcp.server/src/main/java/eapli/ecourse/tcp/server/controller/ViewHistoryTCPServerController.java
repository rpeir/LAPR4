package eapli.ecourse.tcp.server.controller;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardUpdate.application.ViewUpdatesController;
import eapli.ecourse.boardUpdate.domain.Update;
import eapli.ecourse.boardUpdate.dto.UpdateDTO;
import eapli.ecourse.tcp.infrastructure.MessageTCP;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class ViewHistoryTCPServerController extends BaseTCPServerController<ViewUpdatesController>{
    public ViewHistoryTCPServerController(ViewUpdatesController controller) {
        super(controller);
    }
    public ViewHistoryTCPServerController() {
        super(new ViewUpdatesController());
    }
    public String listActiveBoards(MessageTCP message) {
        if(!sessionManager.isValidSession(message.sessionID())){
            throw new IllegalArgumentException("Invalid session");
        }
        try {
            Iterable<Board> boards = controller.listUserBoards(sessionManager.getUsername(message.sessionID()));
            StringBuilder builder = new StringBuilder();
            for (Board b : boards) {
                builder.append(b.board_title());
                builder.append("\0");
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    public byte[] listBoardUpdates(String boardTitle,MessageTCP message) throws IOException {
        if(!sessionManager.isValidSession(message.sessionID())){
            throw new IllegalArgumentException("Invalid session");
        }
        try{
        Iterable<Update> updates = controller.listBoardHistory(boardTitle);
        LinkedList<UpdateDTO> updatesDTO = new LinkedList<>();
        for (Update u : updates) {
            updatesDTO.add(u.toDTO());
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(updatesDTO.toArray(new UpdateDTO[0]));
        return os.toByteArray();
    }catch (Exception e){
        e.printStackTrace();
        throw new IllegalArgumentException(e.getMessage());
    }
    }
}
