package eapli.ecourse.tcp.client.postit;

import eapli.ecourse.tcp.client.BaseTCPController;
import eapli.ecourse.tcp.infrastructure.MessageCodesTCP;
import eapli.ecourse.tcp.infrastructure.MessageTCP;

import java.net.Socket;
import java.util.List;

import static eapli.ecourse.tcp.client.TcpSharedBoardClientApp.sessionID;

public class UndoLastChangePostItTCPClientController extends BaseTCPController {
    public UndoLastChangePostItTCPClientController(Socket sock) {
        super(sock);
    }

    public List<String> listAvailableBoards() {
        mf.sendMessage(VERSION, MessageCodesTCP.AVAILABLE_BOARDS_UNDO, "", sessionID);
        MessageTCP msg = mf.readMessage();
        if (msg.code() == MessageCodesTCP.ERR) throw new IllegalArgumentException(new String(msg.data()));
        String[] boards = new String(msg.data()).split("\0");
        return List.of(boards);
    }

    public void undoLastChangePostIt(String boardTitle, int row, int column) {
        mf.sendMessage(VERSION, MessageCodesTCP.UNDO_LAST_CHANGE_POSTIT, boardTitle + "\0" + row + "\0" + column, sessionID);
        MessageTCP msg = mf.readMessage();
        if (msg.code() == MessageCodesTCP.ERR) throw new IllegalArgumentException(new String(msg.data()));
    }
}
