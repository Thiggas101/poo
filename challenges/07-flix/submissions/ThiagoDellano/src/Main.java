public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:5432/postgres";
        String user = "postgres.snghnxpdoffuasscqmms";
        String password = "";
        String filePath = "/home/thiago/Área de trabalho/idp/3Semestre/poo/challenges/07-flix/data/new_films.txt";
        
        List<Film> films = FileReaderUtil.readFilmsFromFile(filePath);

                try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                // Inserir filmes
                String insertSQL = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
                    for (Film f : films) {
                        stmt.setString(1, f.getTitle());
                        stmt.setInt(2, f.getLanguageId());
                        stmt.setInt(3, f.getRentalDuration());
                        stmt.setDouble(4, f.getRentalRate());
                        stmt.setDouble(5, f.getReplacementCost());
                        stmt.executeUpdate();
                    }
                }

                // Atualizar rental_rate em 10%
                String updateSQL = "UPDATE film SET rental_rate = rental_rate * 1.1";
                try (PreparedStatement stmt = conn.prepareStatement(updateSQL)) {
                    stmt.executeUpdate();
                }

                // Exibir filmes com rent_duration = 99
                String selectSQL = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";
                try (PreparedStatement stmt = conn.prepareStatement(selectSQL);
                     ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        String title = rs.getString("title");
                        double rate = rs.getDouble("rental_rate");
                        System.out.println(title + " - R$" + String.format("%.2f", rate));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro no banco de dados: " + e.getMessage());
        }
    }
}
