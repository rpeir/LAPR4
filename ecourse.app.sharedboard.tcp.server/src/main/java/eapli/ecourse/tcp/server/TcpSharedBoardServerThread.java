package eapli.ecourse.tcp.server;

import eapli.ecourse.tcp.server.controller.*;
import eapli.ecourse.tcp.infrastructure.MessageCodesTCP;
import eapli.ecourse.tcp.infrastructure.MessageFormatTCP;
import eapli.ecourse.tcp.infrastructure.MessageTCP;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class TcpSharedBoardServerThread implements Runnable {
    /**
     * The Socket.
     */
    private final Socket sock;
    /**
     * The constant VERSION.
     */
    public static final int VERSION = 1;

    private SynchronizationObject synchronizationObject;

    /**
     * Instantiates a new Tcp srv thread.
     *
     * @param cliSer the cli s
     */
    public TcpSharedBoardServerThread(final Socket cliSer) {
        sock = cliSer;
        this.synchronizationObject = SynchronizationObject.getInstance();
    }

    /**
     * Thread Runnable.
     */
    public void run() {
        MessageTCP message;
        InetAddress clientIP;

        clientIP = sock.getInetAddress();

        System.out.println("New client connection from "
                + clientIP.getHostAddress()
                + ", port number " + sock.getPort());
        try {
            MessageFormatTCP mf = new MessageFormatTCP(sock);
            boolean end = false;
            do {
                try {
                    message = mf.readMessage();
                    String result;
                    byte[] data;

                    switch (message.code()) {
                        case MessageCodesTCP.COMMTEST:
                            System.out.println("Received communication test request");
                            mf.sendMessage(VERSION, MessageCodesTCP.ACK, "");
                            break;
                        case MessageCodesTCP.ACK:
                            break;
                        case MessageCodesTCP.AUTH:
                            long sessionId = new AuthenticateTCPServerController().authenticate(message);

                            mf.sendMessage(VERSION, MessageCodesTCP.ACK, "", sessionId);
                            break;
                        case MessageCodesTCP.GET_BOARDS:
                            result = new HTTPServerTCPServerController().getBoards(message);

                            mf.sendMessage(VERSION, MessageCodesTCP.ACK, result);
                            break;
                        case MessageCodesTCP.GET_BOARD:
                            try {

                                synchronizationObject.startReading(new String(message.data()));
                                data = new HTTPServerTCPServerController().getBoard(new String(message.data()), message);

                                mf.sendBigMessage(VERSION, MessageCodesTCP.ACK, data);
                            } catch (Exception e) {
                                e.printStackTrace();
                                mf.sendBigMessage(VERSION, MessageCodesTCP.ERR, e.getMessage().getBytes());
                            }
                            break;
                        case MessageCodesTCP.LISTBOARDS:
                            result = new ShareBoardTCPServerController().listActiveBoards(message);

                            mf.sendMessage(VERSION, MessageCodesTCP.ACK, result);
                            break;
                        case MessageCodesTCP.BOARD_PERMISSIONS:
                            result = new ShareBoardTCPServerController().getPermissions(message);

                            mf.sendMessage(VERSION, MessageCodesTCP.ACK, result);
                            break;
                        case MessageCodesTCP.SHARE_BOARD:
                            new ShareBoardTCPServerController().shareBoard(message);

                            mf.sendMessage(VERSION, MessageCodesTCP.ACK, "");

                            break;
                        case MessageCodesTCP.ACTIVE_BOARDS:
                            result = new ArchiveBoardServerTCPController().listActiveBoards(message);

                            mf.sendMessage(VERSION, MessageCodesTCP.ACK, result);
                            break;
                        case MessageCodesTCP.ARCHIVE_BOARD:
                            new ArchiveBoardServerTCPController().archiveBoard(message);

                            mf.sendMessage(VERSION, MessageCodesTCP.ACK, "");

                            break;
                        case MessageCodesTCP.CREATE_BOARD:
                            synchronizationObject.startReading(new String(message.data()));
                            new CreateBoardTCPController().createBoard(message);

                            mf.sendMessage(VERSION, MessageCodesTCP.ACK, "");

                            break;
                        case MessageCodesTCP.BOARD_HISTORY:
                            data = new ViewHistoryTCPServerController().listBoardUpdates(new String(message.data()), message);
                            mf.sendMessage(VERSION, MessageCodesTCP.ACK, data);

                            break;
                        case MessageCodesTCP.UPDATE_ACTIVE_BOARDS:
                            result = new ViewHistoryTCPServerController().listActiveBoards(message);

                            mf.sendMessage(VERSION, MessageCodesTCP.ACK, result);

                            break;
                        case MessageCodesTCP.DISCONN:
                            new AuthenticateTCPServerController().terminateSession(message);
                            end = true;
                            break;
                        case MessageCodesTCP.LOGOUT:
                            new AuthenticateTCPServerController().terminateSession(message);
                            System.out.println("Client with sessionID "+message.sessionID()+" logged out");
                            mf.sendMessage(VERSION, MessageCodesTCP.ACK, "");
                            break;
                        case MessageCodesTCP.BOARDS_SHARED:
                            String boardsShared = new CreatePostItServerTCPController().listUserBoardsShared(message);
                            mf.sendMessage(VERSION, MessageCodesTCP.ACK, boardsShared);
                            break;
                        case MessageCodesTCP.CREATE_POSTIT:
                            result = new String(message.data());
                            String[] strContent = result.split("\0");
                            String contentType = strContent[0];
                            String boardTitle = strContent[1];
                            String row = strContent[2];
                            String column = strContent[3];
                            mf.sendMessage(VERSION, MessageCodesTCP.ACK, "");
                            try {
                                synchronizationObject.startWriting(boardTitle, row, column);
                                MessageTCP content = mf.readBigMessage();
                                if (content.code() == MessageCodesTCP.CREATE_POSTIT) {
                                    byte[] postIt = new CreatePostItServerTCPController().createPostIt(contentType, content.data(), boardTitle, row, column, message.sessionID());
                                    mf.sendBigMessage(VERSION, MessageCodesTCP.ACK, postIt);
                                } else {
                                    System.err.println(new String(content.data()));
                                }
                            } catch (IOException ignored) {

                            } catch (Exception e) {
                                e.printStackTrace();
                                mf.sendBigMessage(VERSION, MessageCodesTCP.ERR, e.getMessage().getBytes());
                            } finally {
                                synchronizationObject.finishingWriting(boardTitle, row, column);
                            }
                            break;
                        case MessageCodesTCP.BOARDS_WRITE:
                            String boardsWrite = new ChangePostItServerTCPController().listBoardsWithWritePermission(message);
                            mf.sendMessage(VERSION, MessageCodesTCP.ACK, boardsWrite);
                            break;
                        case MessageCodesTCP.CHANGE_POSTIT:
                            String[] msg_data = new String(message.data()).split("\0");
                            String boardTitle2 = msg_data[0];
                            String row2 = msg_data[1];
                            String column2 = msg_data[2];
                            String contentType2 = msg_data[3];
                            mf.sendMessage(VERSION, MessageCodesTCP.ACK, "");
                            MessageTCP content_msg = mf.readBigMessage();
                            if (content_msg.code() == MessageCodesTCP.CHANGE_POSTIT) {
                                synchronizationObject.startWriting(boardTitle2, row2, column2);
                                try {
                                    new ChangePostItServerTCPController().changePostIt(boardTitle2, Integer.parseInt(row2), Integer.parseInt(column2), contentType2, content_msg.data(), message);
                                    mf.sendMessage(VERSION, MessageCodesTCP.ACK, "");
                                } finally {
                                    synchronizationObject.finishingWriting(boardTitle2, row2, column2);
                                }
                            } else {
                                System.err.println(new String(content_msg.data()));
                            }
                            break;
                        case MessageCodesTCP.MOVE_POSTIT:
                            String[] msg_data2 = new String(message.data()).split("\0");
                            String boardTitle3 = msg_data2[0];
                            String row3 = msg_data2[1];
                            String column3 = msg_data2[2];
                            String new_row = msg_data2[3];
                            String new_column = msg_data2[4];
                            synchronizationObject.startWriting(boardTitle3, row3, column3);
                            synchronizationObject.startWriting(boardTitle3, new_row, new_column);
                            try {
                                new ChangePostItServerTCPController().movePostIt(boardTitle3, Integer.parseInt(row3),
                                        Integer.parseInt(column3), Integer.parseInt(new_row), Integer.parseInt(new_column), message);

                                mf.sendMessage(VERSION, MessageCodesTCP.ACK, "");
                            } finally {
                                synchronizationObject.finishingWriting(boardTitle3, row3, column3);
                                synchronizationObject.finishingWriting(boardTitle3, new_row, new_column);
                            }
                            break;
                        case MessageCodesTCP.DELETE_POSTIT:
                            String[] msg_data3 = new String(message.data()).split("\0");
                            String boardTitle4 = msg_data3[0];
                            String row4 = msg_data3[1];
                            String column4 = msg_data3[2];
                            synchronizationObject.startWriting(boardTitle4, row4, column4);
                            try {
                                new ChangePostItServerTCPController().deletePostIt(boardTitle4, Integer.parseInt(row4), Integer.parseInt(column4), message);
                                mf.sendMessage(VERSION, MessageCodesTCP.ACK, "");
                            } finally {
                                synchronizationObject.finishingWriting(boardTitle4, row4, column4);
                            }
                            break;
                        case MessageCodesTCP.AVAILABLE_BOARDS_UNDO:
                            String msg_data4 = new UndoLastChangePostItTCPServerController().listAvailableBoards(message);
                            mf.sendMessage(VERSION, MessageCodesTCP.ACK, msg_data4);
                            break;
                        case MessageCodesTCP.UNDO_LAST_CHANGE_POSTIT:
                            String[] args = new String(message.data()).split("\0");
                            String boardTitle5 = args[0];
                            String row5 = args[1];
                            String column5 = args[2];
                            synchronizationObject.startWriting(boardTitle5, row5, column5);
                            try {
                                new UndoLastChangePostItTCPServerController().undoLastChangePostIt(boardTitle5, Integer.parseInt(row5), Integer.parseInt(column5), message.sessionID());
                                mf.sendMessage(VERSION, MessageCodesTCP.ACK, "");
                            } finally {
                                synchronizationObject.finishingWriting(boardTitle5, row5, column5);
                            }
                            break;
                        default:
                            System.out.println(message.code());
                            mf.sendMessage(VERSION, MessageCodesTCP.ERR, "Invalid Code");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    mf.sendMessage(VERSION, MessageCodesTCP.ERR, e.getMessage());
                }
            } while (!end);

            mf.sendMessage(VERSION, MessageCodesTCP.ACK, "");
            System.out.println("Client " + clientIP.getHostAddress()
                    + ", port number: " + sock.getPort()
                    + " disconnected");

            sock.close();
        } catch (IOException ex) {
            System.out.println("IOException");

        }
    }

}
