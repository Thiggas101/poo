package br.edu.idp.cc.poo.dvdrental.dao;

import br.edu.idp.cc.poo.dvdrental.model.Film;
import br.edu.idp.cc.poo.dvdrental.util.AuditLogger;
import br.edu.idp.cc.poo.dvdrental.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {

    public void insert(Film film) throws Exception {
        String sql = "INSERT INTO film(title, description, release_year, language_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, film.getTitle());
            ps.setString(2, film.getDescription());
            ps.setInt(3, film.getReleaseYear());
            ps.setInt(4, film.getLanguageId());
            ps.executeUpdate();
            AuditLogger.log("Inserted film: " + film.getTitle());
        }
    }

    public Film findById(int id) throws Exception {
        String sql = "SELECT film_id, title, description, release_year, language_id FROM film WHERE film_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Film(
                        rs.getInt("film_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("release_year"),
                        rs.getInt("language_id")
                    );
                }
                return null;
            }
        }
    }

    public List<Film> findByTitle(String titlePattern) throws Exception {
        String sql = "SELECT film_id, title, description, release_year, language_id FROM film WHERE title ILIKE ?";
        List<Film> list = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + titlePattern + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Film(
                        rs.getInt("film_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("release_year"),
                        rs.getInt("language_id")
                    ));
                }
            }
        }
        return list;
    }
}
