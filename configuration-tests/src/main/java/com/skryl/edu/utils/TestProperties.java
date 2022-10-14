package com.skryl.edu.utils;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author Skryl D.V. on 2022-10-14
 */
public class TestProperties {
    private static final Logger log = Logger.getLogger(TestProperties.class.getName());

    private final Properties properties;

    public TestProperties() {
        try {
            properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            Map<String, String> environment = System.getenv();
            environment.forEach(properties::setProperty);
        } catch (IOException e) {
            log.warning("failed to load properties for tests");
            throw new RuntimeException(e);
        }
    }

    public String getValue(String propertyName) {
        return (String)properties.get(propertyName);
    }

    public String getValueOrDefault(String propertyName, String defaultValue) {
        Object value = properties.get(propertyName);
        if(value == null) {
            return defaultValue;
        }
        return (String)value;
    }
}
