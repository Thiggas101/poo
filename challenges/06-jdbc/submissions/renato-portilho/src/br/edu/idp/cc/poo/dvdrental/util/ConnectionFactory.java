package br.edu.idp.cc.poo.dvdrental.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final String PROPERTIES_FILE = "db.properties";

    public static Connection obterConexao() throws SQLException, IOException {
        Properties props = new Properties();
        try (InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                throw new IOException("Arquivo " + PROPERTIES_FILE + " não encontrado no classpath");
            }
            props.load(input);
        }

        String url = props.getProperty("db.url");
        String usuario = props.getProperty("db.user");
        String senha = props.getProperty("db.password");

        return DriverManager.getConnection(url, usuario, senha);
    }

    public static void testarConexao() {
        try (Connection con = obterConexao()) {
            System.out.println("Conexão com o banco estabelecida com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao conectar no banco: " + e.getMessage());
        }
    }
}
