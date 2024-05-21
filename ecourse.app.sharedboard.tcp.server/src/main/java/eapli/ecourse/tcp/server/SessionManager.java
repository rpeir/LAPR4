package eapli.ecourse.tcp.server;

import eapli.framework.general.domain.model.EmailAddress;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private static SessionManager instance;
    private final Map<Long, EmailAddress> activeSessions;
    private final SecureRandom rand = new SecureRandom();
    private SessionManager() {
        activeSessions = new HashMap<>();
    }
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }
    public Long createSession(EmailAddress username) {
        long sessionID;
        do {
            sessionID = rand.nextLong();
        } while (activeSessions.containsKey(sessionID));
        activeSessions.put(sessionID, username);
        return sessionID;
    }
    public boolean isValidSession(long sessionID) {
        return activeSessions.containsKey(sessionID);
    }
    public EmailAddress getUsername(long sessionID ) {
        return activeSessions.get(sessionID);
    }
    public void removeSession(long sessionID) {
        activeSessions.remove(sessionID);
    }

}
