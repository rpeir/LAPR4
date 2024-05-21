package eapli.ecourse.app.sharedBoard.common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MessageFormat {
    private static final int VERSION_OFFSET = 0;
    private static final int VERSION_LENGTH = 1;
    private static final int CODE_OFFSET = 1;
    private static final int CODE_LENGTH = 1;
    private static final int D_LENGTH_1_OFFSET = 2;
    private static final int D_LENGTH_1_LENGTH = 1;
    private static final int D_LENGTH_2_OFFSET = 3;
    private static final int D_LENGTH_2_LENGTH = 1;
    private static final int DATA_OFFSET = 4;
    private static final int DATA_DEFAULT_SIZE = 8192;


    /**
     * The Sock.
     */
    private Socket sock;
    /**
     * The S out.
     */
    private DataOutputStream sOut;

    /**
     * The S in.
     */
    private DataInputStream sIn;

    /**
     * 1 byte in decimal.
     */
    private static final int BYTE = 256;

    /**
     * Instantiates a new Message format.
     *
     * @param sockp the sockp
     */
    public MessageFormat(final Socket sockp) {
        try {
            this.sock = sockp;
            this.sOut = new DataOutputStream(sockp.getOutputStream());
            this.sIn = new DataInputStream(sockp.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Send message.
     *
     * @param version the version
     * @param code    the code
     * @param text    the text
     */
    public void sendMessage(final int version,
                            final int code,
                            final String text) {
        try {
            byte[] data = new byte[8988];
            byte[] message = text.getBytes();

            int d_length_1 = message.length % BYTE;
            int d_length_2 = message.length / BYTE;
            data[0] = (byte) version;
            data[1] = (byte) code;
            data[2] = (byte) d_length_1;
            data[3] = (byte) d_length_2;
            System.arraycopy(message, 0, data, 4, message.length);
            sOut.write(data, 0, data.length);



            /*
            sOut.writeByte(version);
            sOut.writeByte(code);
            sOut.writeByte(d_length_1);
            sOut.writeByte(d_length_2);
            sOut.write(data, 0, dataLength);

             */
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Read message message.
     *
     * @return the message
     */
    public Message readMessage() {
        int version;
        int code;
        int d_length_1;
        int d_length_2;
        byte[] data = new byte[DATA_DEFAULT_SIZE];
        byte[] message = new byte[DATA_DEFAULT_SIZE];

        try {
            sIn.readFully(data);
            // sIn.read(data, 0, 4);
            version = data[VERSION_OFFSET];
            System.out.println("version: " + version);
            code = data[CODE_OFFSET];
            System.out.println("code: " + code);
            d_length_1 = data[D_LENGTH_1_LENGTH];
            System.out.println("d_lenght_1: " + d_length_1);
            d_length_2 = data[D_LENGTH_2_LENGTH];
            System.out.println("d_lenght_2: " + d_length_2);
            int dataSize = d_length_1 + BYTE * d_length_2;
             System.out.println("data size: " + dataSize);
            //sIn.read(data,DATA_OFFSET,dataSize);
            System.arraycopy(data, DATA_OFFSET, message, 0, dataSize);


//            int version = sIn.readUnsignedByte();
//            int code = sIn.readUnsignedByte();
//            int d_length_1 = sIn.readUnsignedByte();
//            int d_length_2 = sIn.readUnsignedByte();
//
//            // calculate data length
//            int dataLength = d_length_1 + (d_length_2 * BYTE);
//
//            byte[] data = new byte[dataLength];
//
//            if (dataLength > 0) {
//                sIn.readFully(data);
//            }

           // return new Message(version, code, d_length_1, d_length_2, data);
            return new Message(version,code,d_length_1,d_length_2,message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
