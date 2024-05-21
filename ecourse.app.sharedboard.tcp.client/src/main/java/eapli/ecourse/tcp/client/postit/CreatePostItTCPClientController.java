package eapli.ecourse.tcp.client.postit;

import eapli.ecourse.postit.domain.Content;
import eapli.ecourse.postit.domain.ContentType;
import eapli.ecourse.tcp.client.BaseTCPController;
import eapli.ecourse.postit.domain.PostIt;
import eapli.ecourse.tcp.client.TcpSharedBoardClientApp;
import eapli.ecourse.tcp.infrastructure.MessageCodesTCP;
import eapli.ecourse.tcp.infrastructure.MessageTCP;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreatePostItTCPClientController extends BaseTCPController {

    public CreatePostItTCPClientController(Socket sock) {
        super(sock);
    }

    public List<String> listUserBoardsShared() {
        mf.sendMessage(VERSION,MessageCodesTCP.BOARDS_SHARED,"", TcpSharedBoardClientApp.sessionID);
        MessageTCP result = mf.readMessage();
        String data = new String(result.data());
        if (data.length() == 0){
            return new ArrayList<>();
        }
        return Arrays.asList(data.split("\0"));
    }

    public PostIt createPostIt(String input,String contentType,String content) throws IOException, ClassNotFoundException {
        mf.sendMessage(VERSION,MessageCodesTCP.CREATE_POSTIT,input,TcpSharedBoardClientApp.sessionID);
        MessageTCP contentRequest = mf.readMessage();
        if (contentRequest.code() == MessageCodesTCP.ERR){
            throw new IllegalArgumentException(new String(contentRequest.data()));
        }
        byte[] contentBytes;
        try {
            if (ContentType.TEXT.equals(ContentType.valueOf(contentType))) {
                contentBytes = Content.convertTextToByteArray(content);
            } else{
                contentBytes = Content.convertImageToByteArray(content);
            }
        } catch (Exception e) {
            mf.sendBigMessage(VERSION,MessageCodesTCP.ERR,e.getMessage().getBytes());
            throw e;
        }

        if (contentRequest.code() == MessageCodesTCP.ACK){
            mf.sendBigMessage(VERSION,MessageCodesTCP.CREATE_POSTIT,contentBytes);
        }else {
            throw new IllegalArgumentException(new String(contentRequest.data()));
        }
        MessageTCP result = mf.readBigMessage();
        if (result.code() == MessageCodesTCP.ERR){
            throw new IllegalArgumentException(new String(result.data()));
        }
        ByteArrayInputStream is = new ByteArrayInputStream(result.data());
        ObjectInputStream ois = new ObjectInputStream(is);
        return (PostIt) ois.readObject();
    }


}
