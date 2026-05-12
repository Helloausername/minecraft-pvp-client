package com.pvpclient.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Configuration management
 */
public class Config {
    private static final Path CONFIG_DIR = Paths.get("pvpclient_config");
    private static final Path CONFIG_FILE = CONFIG_DIR.resolve("settings.properties");
    private Properties properties;

    public Config() {
        this.properties = new Properties();
        loadConfig();
    }

    public void loadConfig() {
        try {
            if (!Files.exists(CONFIG_DIR)) {
                Files.createDirectories(CONFIG_DIR);
            }

            if (Files.exists(CONFIG_FILE)) {
                properties.load(Files.newInputStream(CONFIG_FILE));
            }
        } catch (IOException e) {
            System.err.println("[PvP Client] Failed to load config: " + e.getMessage());
        }
    }

    public void saveConfig() {
        try {
            if (!Files.exists(CONFIG_DIR)) {
                Files.createDirectories(CONFIG_DIR);
            }

            properties.store(Files.newOutputStream(CONFIG_FILE), "PvP Client Configuration");
        } catch (IOException e) {
            System.err.println("[PvP Client] Failed to save config: " + e.getMessage());
        }
    }

    public String getString(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public void setString(String key, String value) {
        properties.setProperty(key, value);
    }

    public int getInt(String key, int defaultValue) {
        try {
            return Integer.parseInt(properties.getProperty(key, String.valueOf(defaultValue)));
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public void setInt(String key, int value) {
        properties.setProperty(key, String.valueOf(value));
    }

    public float getFloat(String key, float defaultValue) {
        try {
            return Float.parseFloat(properties.getProperty(key, String.valueOf(defaultValue)));
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public void setFloat(String key, float value) {
        properties.setProperty(key, String.valueOf(value));
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return Boolean.parseBoolean(properties.getProperty(key, String.valueOf(defaultValue)));
    }

    public void setBoolean(String key, boolean value) {
        properties.setProperty(key, String.valueOf(value));
    }
}
