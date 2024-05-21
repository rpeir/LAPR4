package eapli.ecourse.tcp.client.boardManagement;

import eapli.ecourse.tcp.client.BaseTCPController;
import eapli.ecourse.tcp.client.TcpSharedBoardClientApp;
import eapli.ecourse.tcp.infrastructure.MessageCodesTCP;
import eapli.ecourse.tcp.infrastructure.MessageTCP;

import java.net.Socket;
import java.util.Arrays;

public class ArchiveBoardTCPClientController extends BaseTCPController {

    public ArchiveBoardTCPClientController(Socket sock) {
        super(sock);
    }


    public Iterable<String> listActiveBoards() {
        mf.sendMessage(VERSION, MessageCodesTCP.ACTIVE_BOARDS, "", TcpSharedBoardClientApp.sessionID);

        MessageTCP result = mf.readMessage();

        String data = new String(result.data());

        if (result.code() == MessageCodesTCP.ERR) {
            throw new IllegalArgumentException(data);
        }

        return Arrays.asList(data.split("\0"));
    }

    public void archiveBoard(String selectedBoard) {
        mf.sendMessage(VERSION, MessageCodesTCP.ARCHIVE_BOARD, selectedBoard, TcpSharedBoardClientApp.sessionID);

        MessageTCP result = mf.readMessage();

        String data = new String(result.data());

        if (result.code() != MessageCodesTCP.ACK) {
            throw new IllegalArgumentException(data);
        }
    }
}
