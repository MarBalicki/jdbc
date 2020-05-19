package com.java.jdbc;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
public class MysqlConnectionParameters {
    private final static String MYSQL_PROPERTIES_FILENAME = "/jdbc.properties";
    private String username;
    private String password;
    private String databaseName;
    private String databaseHost;
    private String databasePort;

    public MysqlConnectionParameters() {
        init();
    }

    private void init() {
        try {
            Properties propertiesHolder = loadProperties();
            username = propertiesHolder.getProperty("database.jdbc.username");
            password = propertiesHolder.getProperty("database.jdbc.password");
            databaseName = propertiesHolder.getProperty("database.jdbc.name");
            databaseHost = propertiesHolder.getProperty("database.jdbc.host");
            databasePort = propertiesHolder.getProperty("database.jdbc.port");

        } catch (IOException e) {
            System.err.println("Nie można załadować zawartości z pliku.");
            e.printStackTrace();
        }

    }

    private Properties loadProperties() throws IOException {
        Properties properties = new Properties();

        InputStream jdbcPropertiesStream = this.getClass().getResourceAsStream(MYSQL_PROPERTIES_FILENAME);
        if (jdbcPropertiesStream == null) {
            System.err.println("Brak pliku konfiguracyjnego w resources. Nazwa brakującego pliku jdbc.properties");
            System.exit(99);
        }
        properties.load(jdbcPropertiesStream);
        return properties;
    }

}
