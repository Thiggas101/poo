import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class StatementSelectDemo {
    public static void main(String[] args) {
        Properties props = new Properties();

        try {
            try (var inputStream = Files.newInputStream(Paths.get("db.properties"))) {
                props.load(inputStream);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar arquivo de propriedades: " + e.getMessage());
            return;
        }

        final String DATABASE_URL = props.getProperty("url");
        final String USER = props.getProperty("user");
        final String PASSWORD = props.getProperty("password");
        
        final String SELECT_QUERY = "SELECT * FROM film";

        try (
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY)
        ) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            System.out.printf("Tabela FILM do banco dvdrental:%n%n");

            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-20s\t", metaData.getColumnName(i));
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
