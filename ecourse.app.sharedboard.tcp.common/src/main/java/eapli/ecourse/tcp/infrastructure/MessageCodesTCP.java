package eapli.ecourse.tcp.infrastructure;

public class MessageCodesTCP {
    /**
     * The constant COMMTEST.
     */
    public static final int COMMTEST = 0;
    /**
     * The constant DISCONN.
     */
    public static final int DISCONN = 1;
    /**
     * The constant ACK.
     */
    public static final int ACK = 2;
    /**
     * The constant ERR.
     */
    public static final int ERR = 3;
    /**
     * The constant AUTH.
     */
    public static final int AUTH = 4;
    public static final int GET_BOARDS = 5;
    public static final int GET_BOARD = 6;
    public static final int LISTBOARDS = 7;
    public static final int BOARD_PERMISSIONS = 8;
    public static final int SHARE_BOARD = 9;
    public static final int ACTIVE_BOARDS = 10;
    public static final int ARCHIVE_BOARD = 11;
    public static final int CREATE_BOARD = 12;
    public static final int BOARD_HISTORY=13;
    public static final int UPDATE_ACTIVE_BOARDS = 14;
    public static final int BOARDS_SHARED = 15;
    public static final int CREATE_POSTIT = 16;
    public static final int BOARDS_WRITE = 17;
    public static final int CHANGE_POSTIT = 18;
    public static final int MOVE_POSTIT = 19;
    public static final int DELETE_POSTIT = 20;
    public static final int AVAILABLE_BOARDS_UNDO = 21;
    public static final int UNDO_LAST_CHANGE_POSTIT = 22;
    public static final int LOGOUT = 23;

    private MessageCodesTCP() {
        // Private constructor to prevent instantiation
    }
}
