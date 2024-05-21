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
package eapli.ecourse.infrastructure.bootstrapers;

import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.strings.util.Strings;
import eapli.framework.validations.Invariants;
import eapli.ecourse.usermanagement.domain.UserBuilderHelper;

/**
 * eCourse Bootstrapping data.
 */
@SuppressWarnings("squid:S106")
public class ECourseBootstrapper implements Action {
	private static final Logger LOGGER = LogManager.getLogger(ECourseBootstrapper.class);

	private static final String ADMIN_PWD = "AdminPassword10";
	private static final String ADMIN = "admin@email.org";
	private final AuthorizationService authz = AuthzRegistry.authorizationService();
	private final AuthenticationService authenticationService = AuthzRegistry.authenticationService();
	private final UserRepository userRepository = PersistenceContext.repositories().users();

	@Override
	public boolean execute() {
		registerAdmin(userRepository);
		authenticateForBootstrapping();

		// declare bootstrap actions
		final Action[] actions = { new StudentsBootstrapper(), new TeachersBootstrapper(), new CourseBootsrapper() , new ExamsBootstrapper(), new BoardBootstrapper()};

		// execute all bootstrapping
		boolean ret = true;
		for (final Action boot : actions) {
			System.out.println("Bootstrapping " + nameOfEntity(boot) + "...");
			ret &= boot.execute();
		}
		return ret;
	}

	/**
	 * Register a manager user (admin) directly in the persistence layer.
	 */
	public static boolean registerAdmin(final UserRepository userRepository) {
		final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
		userBuilder.withUsername(ADMIN).withPassword(ADMIN_PWD).withName("Main", "Admin")
				.withEmail(ADMIN).withRoles(ECourseRoles.MANAGER_USER);
		final SystemUser newUser = userBuilder.build();

		try {
			final SystemUser admin = userRepository.save(newUser);
			assert admin != null;
			return true;
		} catch (ConcurrencyException | IntegrityViolationException e) {
			// ignoring exception. assuming it is just a primary key violation
			// due to the tentative of inserting a duplicated user
			LOGGER.warn("Assuming {} already exists (activate trace log for details)", newUser.username());
			LOGGER.trace("Assuming existing record", e);
			return false;
		}
	}

	/**
	 * Authenticate in an admin to be able to register new users
	 */
	protected void authenticateForBootstrapping() {
		authenticationService.authenticate(ADMIN, ADMIN_PWD);
		Invariants.ensure(authz.hasSession());
	}

	private String nameOfEntity(final Action boot) {
		final String name = boot.getClass().getSimpleName();
		return Strings.left(name, name.length() - "Bootstrapper".length());
	}
}
