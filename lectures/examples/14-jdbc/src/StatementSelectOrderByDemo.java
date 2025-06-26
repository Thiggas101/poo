import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class StatementSelectOrderByDemo {
    public static void main(String[] args) throws Exception {
        
        Properties props = new Properties();
        props.load(Files.newInputStream(Paths.get("db.properties")));

        try (Connection conn = DriverManager.getConnection(
                props.getProperty("url"), props.getProperty("user"), props.getProperty("password"))) {

            String sql = "SELECT category_id, name, last_update FROM category ORDER BY category_id";
            
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    System.out.printf("ID: %-3d | Nome: %-20s | Atualizado em: %s%n",
                            rs.getInt("category_id"),
                            rs.getString("name"),
                            rs.getTimestamp("last_update"));
                }
            }
        }
    }
}
