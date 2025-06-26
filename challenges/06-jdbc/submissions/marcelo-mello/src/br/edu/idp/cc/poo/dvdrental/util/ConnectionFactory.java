package br.edu.idp.cc.poo.dvdrental.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.FileInputStream;

public class ConnectionFactory {
    private static final String PROPS_FILE = "db.properties";

    public static Connection getConnection() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream(PROPS_FILE));

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);
    }
}
