/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.ecourse.usermanagement.application;

import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.infrastructure.persistence.RepositoryFactory;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Optional;

@UseCaseController
public class ActivateDeactivateSystemUserController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserManagementService userSvc = AuthzRegistry.userService();
    private RepositoryFactory repo = PersistenceContext.repositories();


    public SystemUser deactivateUser(final SystemUser user) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.MANAGER_USER);

        return userSvc.deactivateUser(user);
    }
    public Iterable<SystemUser> listSystemUsers() {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.MANAGER_USER);
        return userSvc.allUsers();
    }
    public SystemUser findUserByUsername(final String username) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.MANAGER_USER);
        Optional<SystemUser> s = userSvc.userOfIdentity(Username.valueOf(username));
        if (s.isPresent()) {
            return s.get();
        }
        throw new IllegalArgumentException("Unknown username: " + username);
    }
    public Iterable<SystemUser> listActiveSystemUsers() {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.MANAGER_USER);
        return userSvc.activeUsers();
    }
    public Iterable<SystemUser> listDeactivatedSystemUsers() {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.MANAGER_USER);
        return userSvc.deactivatedUsers();
    }
    public SystemUser activateUser(final SystemUser user) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.MANAGER_USER);
        return userSvc.activateUser(user);
    }

}
