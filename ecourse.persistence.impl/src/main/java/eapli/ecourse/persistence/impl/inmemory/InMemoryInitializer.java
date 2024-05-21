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
package eapli.ecourse.persistence.impl.inmemory;

import eapli.ecourse.infrastructure.bootstrapers.ECourseBootstrapper;

/**
 * An initialiser to make sure there is the default bootstrapping data,
 * namely the first manager, when using the in memory repositories.
 */
final class InMemoryInitializer {

	/**
	 * The singleton instance.
	 */
	private static class LazyHolder {
		private static final InMemoryInitializer INSTANCE = new InMemoryInitializer();

		private LazyHolder() {
		}
	}

	private boolean initialized;

	private InMemoryInitializer() {
		// ensure no public instantiation
	}

	private synchronized void initialize() {
		if (!initialized) {
			new ECourseBootstrapper().execute();
			initialized = true;
		}
	}

	/**
	 * Ensures the singleton instance is initialized.
	 */
	public static void init() {
		LazyHolder.INSTANCE.initialize();
	}
}
