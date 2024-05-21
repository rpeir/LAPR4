package eapli.ecourse.app.sharedBoard.sharedBoardProtocol;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.tcp.infrastructure.MessageCodesTCP;
import eapli.ecourse.tcp.infrastructure.MessageFormatTCP;
import eapli.ecourse.tcp.infrastructure.MessageTCP;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * Controller for the TCP connection to the Shared Board TCP Server
 */
public class SharedBoardTCPController {
    private MessageFormatTCP mf;

    public static final int VERSION = 1;

    public SharedBoardTCPController(MessageFormatTCP mf) {
        this.mf = mf;
    }

    public int sendCommunicationTest(){
        mf.sendMessage(VERSION, MessageCodesTCP.COMMTEST, "");

        MessageTCP result = mf.readMessage();

        return result.code();
    }

    public int sendEndOfSession(){
        mf.sendMessage(VERSION, MessageCodesTCP.DISCONN, "");

        MessageTCP result = mf.readMessage();

        return result.code();
    }

    /**
     * Sends a message to the TCP server to authenticate the user
     * @param data
     * @return user token session id, if the user is authenticated, exception otherwise
     */
    public long authenticate(String data){
        mf.sendMessage(VERSION, MessageCodesTCP.AUTH, data);

        MessageTCP result = mf.readMessage();

        if (result.code() == MessageCodesTCP.ERR) throw new IllegalArgumentException(new String(result.data()));
        if (result.code() == MessageCodesTCP.ACK) return result.sessionID();
        else throw new IllegalArgumentException("Unknown response code from server in authentication: "+result.code());
    }

    /**
     * Sends a message to the TCP server to get the list of boards of the user
     * @param token user token session id
     * @return the list of boards of the user, each string is a board title
     */
    public List<String> getBoards(long token) {
        mf.sendMessage(VERSION, MessageCodesTCP.GET_BOARDS, "", token);

        MessageTCP result = mf.readMessage();

        if (result.code() == MessageCodesTCP.ERR) throw new IllegalArgumentException(new String(result.data()));

        String data = new String(result.data());

        return Arrays.asList(data.split("\0"));
    }

    /**
     * Sends a message to the TCP server to get the board
     * @param boardTitle board title
     * @param token user token session id
     * @return the board
     */
    public Board getBoard(String boardTitle, long token) throws IOException, ClassNotFoundException {
        mf.sendMessage(VERSION, MessageCodesTCP.GET_BOARD, java.net.URLDecoder.decode(boardTitle, StandardCharsets.UTF_8), token);

        MessageTCP msg = mf.readBigMessage();

        if (msg.code() == MessageCodesTCP.ERR) throw new IllegalArgumentException(new String(msg.data()));

        ByteArrayInputStream is = new ByteArrayInputStream(msg.data());
        ObjectInputStream ois = new ObjectInputStream(is);
        return (Board) ois.readObject();
    }

    public void logout(long token) {
        mf.sendMessage(VERSION, MessageCodesTCP.LOGOUT, "", token);

        MessageTCP result = mf.readMessage();

        if (result.code() == MessageCodesTCP.ERR) throw new IllegalArgumentException(new String(result.data()));
        if (result.code() != MessageCodesTCP.ACK) throw new IllegalArgumentException("Unknown response code from server in disconnection: " + result.code());
    }
}
