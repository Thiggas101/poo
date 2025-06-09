package br.edu.idp.cc.poo.dvdrental.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class ConnectionFactory {
    private static final String PROPS_FILE = "/db.properties";

    public static Connection getConnection() throws Exception {
        Properties props = new Properties();
        try (InputStream in = ConnectionFactory.class.getResourceAsStream(PROPS_FILE)) {
            props.load(in);
        }

        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, user, password);
    }
}
