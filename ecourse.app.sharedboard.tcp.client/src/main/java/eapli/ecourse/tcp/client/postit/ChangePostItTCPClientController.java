package eapli.ecourse.tcp.client.postit;

import eapli.ecourse.tcp.client.BaseTCPController;
import eapli.ecourse.tcp.client.TcpSharedBoardClientApp;
import eapli.ecourse.tcp.infrastructure.MessageCodesTCP;
import eapli.ecourse.tcp.infrastructure.MessageTCP;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChangePostItTCPClientController extends BaseTCPController {

    public ChangePostItTCPClientController(Socket sock) {
        super(sock);
    }

    public List<String> listBoardsWithWritePermission() {
        mf.sendMessage(VERSION,MessageCodesTCP.BOARDS_WRITE,"", TcpSharedBoardClientApp.sessionID);
        MessageTCP result = mf.readMessage();
        if (result.code() == MessageCodesTCP.ERR){
            throw new IllegalStateException(new String(mf.readMessage().data()));
        }
        String data = new String(result.data());
        if (data.length() == 0){
            return new ArrayList<>();
        }
        return Arrays.asList(data.split("\0"));
    }

    public void changePostIt(String selectedBoard, int row, int column, String type,byte[] content) {
        mf.sendMessage(VERSION,MessageCodesTCP.CHANGE_POSTIT,selectedBoard + "\0" + String.valueOf(row) + "\0" + String.valueOf(column) + "\0" + type,TcpSharedBoardClientApp.sessionID);
        MessageTCP result = mf.readMessage();
        if (result.code() == MessageCodesTCP.ERR){
            throw new IllegalArgumentException(new String(result.data()));
        }
        mf.sendBigMessage(VERSION,MessageCodesTCP.CHANGE_POSTIT,content);
        MessageTCP result2 = mf.readMessage();
        if (result2.code() == MessageCodesTCP.ERR){
            throw new IllegalArgumentException(new String(result2.data()));
        }
    }

    public void movePostIt(String selectedBoard, int row1, int column1, int row2, int column2) {
        mf.sendMessage(VERSION,MessageCodesTCP.MOVE_POSTIT,selectedBoard + "\0" + String.valueOf(row1) + "\0" + String.valueOf(column1) + "\0" + String.valueOf(row2) + "\0" + String.valueOf(column2),TcpSharedBoardClientApp.sessionID);
        MessageTCP result = mf.readMessage();
        if (result.code() == MessageCodesTCP.ERR){
            throw new IllegalArgumentException(new String(result.data()));
        }
    }

    public void deletePostIt(String selectedBoard, int row, int column) {
        mf.sendMessage(VERSION,MessageCodesTCP.DELETE_POSTIT,selectedBoard + "\0" + String.valueOf(row) + "\0" + String.valueOf(column),TcpSharedBoardClientApp.sessionID);
        MessageTCP result = mf.readMessage();
        if (result.code() == MessageCodesTCP.ERR){
            throw new IllegalArgumentException(new String(result.data()));
        }
    }
}
