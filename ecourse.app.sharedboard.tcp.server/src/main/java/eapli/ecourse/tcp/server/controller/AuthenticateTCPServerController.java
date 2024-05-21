package eapli.ecourse.tcp.server.controller;

import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.ecourse.tcp.infrastructure.MessageTCP;

import java.util.Optional;

public class AuthenticateTCPServerController extends BaseTCPServerController<AuthenticationService> {

    public AuthenticateTCPServerController(AuthenticationService controller) {
        super(controller);
    }

    public AuthenticateTCPServerController() {
        super(AuthzRegistry.authenticationService());
    }

    public long authenticate(final MessageTCP msg) {
        String[] data = new String(msg.data()).split("\0");
        String email = data[0].trim(), password = data[1].trim();

        Optional<UserSession> session = controller
                .authenticate(email, password,
                        ECourseRoles.userRoles());

        if (session.isPresent()) {
            return sessionManager.createSession(EmailAddress.valueOf(email));
        } else {
            throw new IllegalArgumentException("Invalid credentials");
        }
    }

    public void terminateSession(MessageTCP message) {
        if(!sessionManager.isValidSession(message.sessionID())){
            throw new IllegalArgumentException("Invalid session: "+message.sessionID());
        }
        sessionManager.removeSession(message.sessionID());
    }
}