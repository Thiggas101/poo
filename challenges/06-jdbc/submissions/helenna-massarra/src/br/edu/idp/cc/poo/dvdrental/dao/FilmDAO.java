package br.edu.idp.cc.poo.dvdrental.dao;

import br.edu.idp.cc.poo.dvdrental.model.Film;
import br.edu.idp.cc.poo.dvdrental.util.ConnectionFactory;
import br.edu.idp.cc.poo.dvdrental.util.AuditLogger;

import java.sql.*;

public class FilmDAO {

    public void insert(Film film) {
        String sql = "INSERT INTO film (title, description, language_id) VALUES (?, ?, 1)";
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.executeUpdate();
            AuditLogger.log("Inserido filme: " + film.getTitle());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Film findById(int id) {
        String sql = "SELECT * FROM film WHERE film_id = ?";
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Film(rs.getInt("film_id"), rs.getString("title"), rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void findByTitle(String title) {
        String sql = "SELECT * FROM film WHERE title ILIKE ?";
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + title + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("film_id") + " - " + rs.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
