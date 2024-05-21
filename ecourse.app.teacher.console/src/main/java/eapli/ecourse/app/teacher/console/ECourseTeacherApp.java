/*
 * Copyright (c) 2013-2022 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.ecourse.app.teacher.console;

import eapli.ecourse.app.common.console.ECourseBaseApplication;
import eapli.ecourse.app.teacher.console.presentation.FrontMenu;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.usermanagement.domain.ECoursePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;

/**
 * Ecourse User App.
 */
@SuppressWarnings("squid:S106")
public final class ECourseTeacherApp extends ECourseBaseApplication {

	/**
	 * Empty constructor is private to avoid instantiation of this class.
	 */
	private ECourseTeacherApp() {
	}

	public static void main(final String[] args) {
		new ECourseTeacherApp().run(args);
	}
	/**
	 * Configure the authorization service.
	 */
	@Override
	protected void configureAuthz() {
		AuthzRegistry.configure(PersistenceContext.repositories().users(), new ECoursePasswordPolicy(),
				new PlainTextEncoder());

	}
	/**
	 * Configure the main menu.
	 */
	@Override
	protected void doMain(String[] args) {
		new FrontMenu().show();

	}
	/**
	 * Configure the application title.
	 */
	@Override
	protected String appTitle() {
		return "my eCourse App - Teacher";
	}
	/**
	 * Configure the application closing message.
	 */
	@Override
	protected String appGoodbye() {
		return "Thank you for using 'my eCourse' App!";
	}
}
