package com.inte.config;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.util.Objects;

public class Config {

    public static Configuration configuration;

    public static Configuration getInstance() throws ConfigurationException {
        if (configuration == null) {
            Configurations configs = new Configurations();
            configuration = configs.properties(loadPropertiesFile());
        }
        return configuration;
    }

    private static File loadPropertiesFile() {
        String configFile = getEnvProperties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String configFilePath = Objects.requireNonNull(loader.getResource(configFile).getPath());
        return new File(configFilePath);
    }

    private static String getEnvProperties() {
        return "env.properties";
    }

    public static String getBaseUrl() {
        if (Objects.nonNull(System.getProperty("baseUrl"))) {
            return System.getProperty("baseUrl");
        } else {
            return getProperty("baseUrl");
        }
    }

    public static String getProperty(String property) {
        if (System.getProperty(property) != null && !System.getProperty(property).isEmpty()) {
            return System.getProperty(property);
        } else {
            return configuration.getString(property);
        }
    }
}
