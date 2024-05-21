package eapli.ecourse.tcp.client.updateManagement;

import eapli.ecourse.tcp.client.BaseTCPController;
import eapli.ecourse.boardUpdate.dto.UpdateDTO;
import eapli.ecourse.tcp.client.TcpSharedBoardClientApp;
import eapli.ecourse.tcp.infrastructure.MessageTCP;
import eapli.ecourse.tcp.infrastructure.MessageCodesTCP;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class ViewUpdatesTCPClientController extends BaseTCPController {
    public ViewUpdatesTCPClientController(Socket sock) {
        super(sock);
    }
    public Iterable<String>listUserBoards(){
        mf.sendMessage(VERSION, MessageCodesTCP.UPDATE_ACTIVE_BOARDS, "", TcpSharedBoardClientApp.sessionID);
        MessageTCP result=mf.readMessage();
        String data=new String(result.data());
        if(result.code()==MessageCodesTCP.ERR){
            throw new IllegalArgumentException(data);
        }
        return Arrays.asList(data.split("\0"));
    }
    public List<UpdateDTO> listBoardHistory(String board) throws IOException, ClassNotFoundException {
        mf.sendMessage(VERSION, MessageCodesTCP.BOARD_HISTORY, board,TcpSharedBoardClientApp.sessionID);
        MessageTCP result=mf.readMessage();
        if(result.code()==MessageCodesTCP.ERR){
            throw new IllegalArgumentException(new String(result.data()));
        }
        ByteArrayInputStream is = new ByteArrayInputStream(result.data());
        ObjectInputStream ois = new ObjectInputStream(is);
        return List.of((UpdateDTO[]) ois.readObject());

    }
}
