package eapli.ecourse.tcp.client.shareBoardManagement;

import eapli.ecourse.tcp.client.BaseTCPController;
import eapli.ecourse.tcp.client.TcpSharedBoardClientApp;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.ecourse.tcp.infrastructure.MessageCodesTCP;
import eapli.ecourse.tcp.infrastructure.MessageTCP;

import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class ShareBoardTCPClientController extends BaseTCPController {

    public ShareBoardTCPClientController(Socket sock) {
        super(sock);
    }

    public List<String> listActiveBoards() {
        mf.sendMessage(VERSION, MessageCodesTCP.LISTBOARDS, "", TcpSharedBoardClientApp.sessionID);

        MessageTCP result = mf.readMessage();

        String data = new String(result.data());

        if (result.code() == MessageCodesTCP.ERR) {
            throw new IllegalArgumentException(data);
        }

        return Arrays.asList(data.split("\0"));
    }

    public List<String> getPermissions() {
        mf.sendMessage(VERSION, MessageCodesTCP.BOARD_PERMISSIONS, "",TcpSharedBoardClientApp.sessionID);

        MessageTCP result = mf.readMessage();

        String data = new String(result.data());

        if (result.code() == MessageCodesTCP.ERR) {
            throw new IllegalArgumentException(data);
        }

        return Arrays.asList(data.split("\0"));
    }

    public void shareBoard(String selectedBoard, EmailAddress email, String userPermission) {
        mf.sendMessage(VERSION, MessageCodesTCP.SHARE_BOARD, selectedBoard + "\0" + email.toString() + "\0" + userPermission, TcpSharedBoardClientApp.sessionID);

        MessageTCP result = mf.readMessage();

        String data = new String(result.data());

        if (result.code() == MessageCodesTCP.ERR) {
            throw new IllegalArgumentException(data);
        }
    }
}
