/*
 * Copyright (c) 2013-2023 the original author or authors.
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
package eapli.ecourse.app.common.console;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.ecourse.Application;

/**
 * A base class for all console applications.
 */
@SuppressWarnings("squid:S106")
public abstract class ECourseBaseApplication {

	protected static final String SEPARATOR_HR = "============================================";
	private static final Logger LOGGER = LogManager.getLogger(ECourseBaseApplication.class);

	/**
	 * @param args the command line arguments
	 */
	public void run(final String[] args) {
		configure();

		printHeader();

		try {
			doMain(args);

			printFooter();
		} catch (final Exception e) {
			System.out.println(
					"Something unexpected has happened and the application will terminate. Please check the logs.\n");
			LOGGER.error(e);
		}

		// exiting the application, closing all threads
		System.exit(0);
	}
	/**
	 * Prints the application footer.
	 */
	protected void printFooter() {
		System.out.println("\n");
		System.out.println(SEPARATOR_HR);
		System.out.println(appGoodbye());
		System.out.println(SEPARATOR_HR);
	}
	/**
	 * Prints the application header.
	 */
	protected void printHeader() {
		System.out.println(SEPARATOR_HR);
		System.out.println(appTitle() + " " + Application.VERSION);
		System.out.println(Application.COPYRIGHT);
		System.out.println(SEPARATOR_HR);
	}
	/**
	 * Configures the application.
	 */
	protected void configure() {
		configureAuthz();
	}
	/**
	 * Configures the authorization.
	 */
	protected abstract void configureAuthz();
	/**
	 * The main method.
	 * @param args the command line arguments
	 */
	protected abstract void doMain(final String[] args);
	/**
	 * The application title.
	 * @return the application title
	 */
	protected abstract String appTitle();
	/**
	 * The application closing message.
	 * @return the application closing message
	 */
	protected abstract String appGoodbye();
}
