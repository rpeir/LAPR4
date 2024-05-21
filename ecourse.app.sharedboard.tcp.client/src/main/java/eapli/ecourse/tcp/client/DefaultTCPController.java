package eapli.ecourse.tcp.client;

import eapli.ecourse.tcp.infrastructure.MessageCodesTCP;
import eapli.ecourse.tcp.infrastructure.MessageTCP;

import java.net.Socket;

public class DefaultTCPController extends BaseTCPController {

    public DefaultTCPController(Socket sock) {
        super(sock);
    }

    public int sendCommunicationTest(){
        mf.sendMessage(VERSION, MessageCodesTCP.COMMTEST, "");

        MessageTCP result = mf.readMessage();

        return result.code();
    }

    public int sendEndOfSession(){
        mf.sendMessage(VERSION, MessageCodesTCP.DISCONN, "", TcpSharedBoardClientApp.sessionID);

        MessageTCP result = mf.readMessage();

        return result.code();
    }

    public MessageTCP authenticate(String data){
        mf.sendMessage(VERSION, MessageCodesTCP.AUTH, data);

        MessageTCP result = mf.readMessage();

        return result;
    }
}
