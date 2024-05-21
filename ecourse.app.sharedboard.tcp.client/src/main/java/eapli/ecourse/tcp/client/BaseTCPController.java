package eapli.ecourse.tcp.client;

import eapli.ecourse.tcp.infrastructure.MessageFormatTCP;

import java.net.Socket;

public abstract class BaseTCPController {

    protected Socket sock;
    protected MessageFormatTCP mf;
    protected static final int VERSION = 1;

    public BaseTCPController(Socket sock) {
        this.sock = sock;
        this.mf = new MessageFormatTCP(sock);
    }

}
