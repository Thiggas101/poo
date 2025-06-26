import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {
    public static void main(String[] args) {

        try{
            Properties props = new Properties();
            
            try (var inputStream = Files.newInputStream(Paths.get("db.properties"))) {
                props.load(inputStream);
            }

            String url = props.getProperty("url"); //"jdbc:postgresql://localhost:5432/postgres";
            String usuario = props.getProperty("user"); // "postgres";
            String senha = props.getProperty("password"); // *****;

            connectToDatabase(url, usuario, senha);

        } catch(IOException ioex){
            System.err.println("Erro ao ler arquivo de configuração: " + ioex.getMessage());
        }
    }
    private static void connectToDatabase(String url, String usuario, String senha) {
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            System.out.println("Conexão estabelecida com sucesso!");
            System.out.println(conexao.getClientInfo());
            System.out.println(conexao.getSchema());
        } catch (SQLException e) {
            System.err.println("Erro na conexão: " + e.getMessage());
        }
    }
}