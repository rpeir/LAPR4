package eapli.ecourse.tcp.client.boardManagement;

import eapli.ecourse.tcp.client.BaseTCPController;
import eapli.ecourse.tcp.client.TcpSharedBoardClientApp;
import eapli.ecourse.tcp.infrastructure.MessageCodesTCP;
import eapli.ecourse.tcp.infrastructure.MessageTCP;

import java.net.Socket;

public class CreateBoardTCPClientController extends BaseTCPController {
    public CreateBoardTCPClientController(Socket sock) {
        super(sock);
    }

    public void createBoard(String boardTitle) {
        mf.sendMessage(VERSION, MessageCodesTCP.CREATE_BOARD, boardTitle, TcpSharedBoardClientApp.sessionID);

        MessageTCP result = mf.readMessage();

        if (result.code() != MessageCodesTCP.ACK) {
            throw new IllegalArgumentException(new String(result.data()));
        }

    }
}
