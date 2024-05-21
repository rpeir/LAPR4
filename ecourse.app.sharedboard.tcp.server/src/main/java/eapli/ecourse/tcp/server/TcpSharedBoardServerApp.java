package eapli.ecourse.tcp.server;

import eapli.ecourse.boardManagement.updateevent.BoardUpdateEvent;
import eapli.ecourse.boardManagement.updateevent.BoardUpdateHandler;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.usermanagement.domain.ECoursePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.pubsub.EventDispatcher;
import eapli.framework.infrastructure.pubsub.impl.inprocess.service.InProcessPubSub;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpSharedBoardServerApp {
    /**
     * The Sock.
     */
    private static ServerSocket sock;

    /**
     * The PORT.
     */
    private static final int PORT = 9999;

    private static EventDispatcher dispatcher = InProcessPubSub.dispatcher();
    /**
     * Main.
     *
     * @param args the args
     * @throws Exception the exception
     */
    public static void main(final String args[]) throws Exception {
        setupAuthz();
        setupEventHandlers();
        Socket cliSock;

        try {
            System.out.println("Starting server...");
            System.out.println("IP: " + InetAddress.getLocalHost().getHostAddress());
            sock = new ServerSocket(PORT);
        } catch (IOException ex) {
            System.out.println("Failed to open server socket");
            System.exit(1);
        }

        while (true) {
            cliSock = sock.accept();
            new Thread(new TcpSharedBoardServerThread(cliSock)).start();
        }
    }

    private static void setupEventHandlers() {
        dispatcher.subscribe(new BoardUpdateHandler(), BoardUpdateEvent.class);
    }

    private static void setupAuthz() {
        AuthzRegistry.configure(
                PersistenceContext.repositories().users(),
                new ECoursePasswordPolicy(),
                new PlainTextEncoder()
        );
    }
}
