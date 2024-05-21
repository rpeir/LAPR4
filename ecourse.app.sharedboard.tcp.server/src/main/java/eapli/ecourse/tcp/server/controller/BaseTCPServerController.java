package eapli.ecourse.tcp.server.controller;

import eapli.ecourse.tcp.server.SessionManager;

public abstract class BaseTCPServerController<C> {

    protected final C controller;

    protected SessionManager sessionManager = SessionManager.getInstance();

    public BaseTCPServerController(C controller) {
        this.controller = controller;
    }
}
