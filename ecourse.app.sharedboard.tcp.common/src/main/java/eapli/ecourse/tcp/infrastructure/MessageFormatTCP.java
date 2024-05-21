package eapli.ecourse.tcp.infrastructure;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class MessageFormatTCP {
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

    private static final int MAX_SIZE = 255 + BYTE * 255;

    /**
     * Instantiates a new Message format.
     *
     * @param sockp the sockp
     */
    public MessageFormatTCP(final Socket sockp) {
        try {
            this.sock = sockp;
            this.sOut = new DataOutputStream(sockp.getOutputStream());
            this.sIn = new DataInputStream(sock.getInputStream());
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
                            final String text,final Long sessionID) {
        sendMessage(version, code, text.getBytes(), sessionID);
    }

    /**
     * Send message.
     *
     * @param version the version
     * @param code    the code
     * @param data    the data
     */
    public void sendMessage(final int version,
                            final int code,
                            final byte[] data, final Long sessionID) {
        synchronized (this) {
            int dataLength = data.length;

            int d_length_1 = dataLength % BYTE;
            int d_length_2 = dataLength / BYTE;

            try {
                sOut.writeByte(version);
                sOut.writeByte(code);
                sOut.writeByte(d_length_1);
                sOut.writeByte(d_length_2);
                sOut.writeLong(sessionID);
                sOut.write(data, 0, dataLength);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private byte[] intToBytes( final int i ) {
        ByteBuffer bb = ByteBuffer.allocate(4);
        bb.putInt(i);
        return bb.array();
    }

    private int bytesToInt(final byte[] bytes) {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            value += (bytes[i] & 0xFF) << (8 * (3 - i));
        }

        return value;
    }

    public void sendBigMessage(final int version,
                               final int code,
                               final byte[] data,
                               final Long sessionID) {
        synchronized (this) {
            int num = (data.length / MAX_SIZE + 1);
            sendMessage(version, code, intToBytes(data.length), sessionID);
            for(int i = 0; i < num - 1; i++) {
                sendMessage(version, code, Arrays.copyOfRange(data, i * MAX_SIZE, (i+1) * MAX_SIZE), sessionID);
            }
            sendMessage(version, code, Arrays.copyOfRange(data, (num - 1) * MAX_SIZE, data.length), sessionID);
        }
    }

    public void sendBigMessage(final int version,
                               final int code,
                               final byte[] data) {
        sendBigMessage(version, code, data, 0L);
    }

    public MessageTCP readBigMessage() {
        synchronized (this) {
            MessageTCP msgSize = readMessage();
            int size = bytesToInt(msgSize.data());
            ByteArrayOutputStream bigData = new ByteArrayOutputStream();
            int num = (size / MAX_SIZE + 1);
            for(int i = 0; i < num - 1; i++) {
                MessageTCP smallMSG = readMessage();
                try {
                    bigData.write(smallMSG.data());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            MessageTCP smallMSG = readMessage();
            try {
                bigData.write(smallMSG.data());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new MessageTCP(msgSize.version(), msgSize.code(), msgSize.d_length_1(), msgSize.d_length_2(), bigData.toByteArray(), msgSize.sessionID());
        }
    }

    public void sendMessage(final int version,
                            final int code,
                            final byte[] data){
        sendMessage(version, code, data, 0L);
    }
    public void sendMessage(final int version,
                            final int code,
                            final String text){
        sendMessage(version, code, text, 0L);
    }


    /**
     * Read message message.
     *
     * @return the message
     */
    public MessageTCP readMessage() {
        synchronized (this) {
            try {
                int version = sIn.readUnsignedByte();
                int code = sIn.readUnsignedByte();
                int d_length_1 = sIn.readUnsignedByte();
                int d_length_2 = sIn.readUnsignedByte();
                long sessionID = sIn.readLong();

                // calculate data length
                int dataLength = d_length_1 + (d_length_2 * BYTE);

                byte[] data = new byte[dataLength];

                if (dataLength > 0) {
                    sIn.readFully(data);
                }

                return new MessageTCP(version, code, d_length_1, d_length_2, data, sessionID);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
