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
package eapli.ecourse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AppSettings {
	private static final Logger LOGGER = LogManager.getLogger(AppSettings.class);

	private static final String PROPERTIES_RESOURCE = "application.properties";
	private static final String REPOSITORY_FACTORY_KEY = "persistence.repositoryFactory";
	private static final String UI_MENU_LAYOUT_KEY = "ui.menu.layout"; //TODO what does this do?
	private static final String PERSISTENCE_UNIT_KEY = "persistence.persistenceUnit";
	private static final String SCHEMA_GENERATION_KEY = "javax.persistence.schema-generation.database.action";
	private static final String USE_EVENTFUL_CONTROLLERS = "UseEventfulControllers"; //TODO what does this do?

	private static final String MAX_COLUMNS= "Board.maxColumns";
	private static final String MAX_ROWS= "Board.maxRows";

	private final Properties applicationProperties = new Properties();

	public AppSettings() {
		loadProperties();
	}
	/**
	 * Loads the properties.
	 */
	private void loadProperties() {
		try (InputStream propertiesStream = this.getClass().getClassLoader().getResourceAsStream(PROPERTIES_RESOURCE)) {
			if (propertiesStream == null) {
				throw new FileNotFoundException(
						"Property file '" + PROPERTIES_RESOURCE + "' not found in the classpath");
			}
			applicationProperties.load(propertiesStream);
		} catch (final IOException exio) {
			setDefaultProperties();

			LOGGER.warn("Loading default properties", exio);
		}
	}
	/**
	 * Sets the default properties.
	 */
	private void setDefaultProperties() {
		applicationProperties.setProperty(REPOSITORY_FACTORY_KEY,
				"eapli.ecourse.persistence.jpa.JpaRepositoryFactory");
		applicationProperties.setProperty(UI_MENU_LAYOUT_KEY, "horizontal");
		applicationProperties.setProperty(PERSISTENCE_UNIT_KEY, "eapli.eCoursePU");
		applicationProperties.setProperty(MAX_COLUMNS, "10");
		applicationProperties.setProperty(MAX_ROWS, "20");
	}

	public boolean isMenuLayoutHorizontal() {
		return "horizontal".equalsIgnoreCase(this.applicationProperties.getProperty(UI_MENU_LAYOUT_KEY));
	}
	/**
	 * Gets the persistence unit name.
	 *
	 * @return the persistence unit name
	 */
	public String persistenceUnitName() {
		return applicationProperties.getProperty(PERSISTENCE_UNIT_KEY);
	}
	/**
	 * Gets the repository factory.
	 *
	 * @return the repository factory
	 */
	public String repositoryFactory() {
		return applicationProperties.getProperty(REPOSITORY_FACTORY_KEY);
	}
	/**
	 * Gets the extended persistence properties.
	 *
	 * @return the extended persistence properties
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map extendedPersistenceProperties() {
		final Map ret = new HashMap();
		ret.put(SCHEMA_GENERATION_KEY, applicationProperties.getProperty(SCHEMA_GENERATION_KEY));
		return ret;
	}
	/**
	 * Gets the property.
	 *
	 * @param prop the prop
	 * @return the property
	 */
	public String getProperty(final String prop) {
		return applicationProperties.getProperty(prop);
	}
	/**
	 * Use eventful controllers.
	 *
	 * @return true, if successful
	 */
	public boolean useEventfulControllers() {
		return Boolean.parseBoolean(applicationProperties.getProperty(USE_EVENTFUL_CONTROLLERS));
	}
}
