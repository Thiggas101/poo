package br.edu.idp.cc.poo.dvdrental.dao;

import br.edu.idp.cc.poo.dvdrental.model.Film;
import br.edu.idp.cc.poo.dvdrental.util.ConnectionFactory;
import br.edu.idp.cc.poo.dvdrental.util.AuditLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {
    public void insert(Film film) throws SQLException {
        String sql = "INSERT INTO film (title, description, language_id) VALUES (?, ?, 1)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.executeUpdate();
            AuditLogger.log("INSERT: " + film.getTitle());
        }
    }

    public List<Film> findAll() throws SQLException {
        List<Film> list = new ArrayList<>();
        String sql = "SELECT film_id, title, description FROM film";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Film(rs.getInt("film_id"), rs.getString("title"), rs.getString("description")));
            }
        }
        return list;
    }

    public Film findById(int id) throws SQLException {
        String sql = "SELECT * FROM film WHERE film_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Film(rs.getInt("film_id"), rs.getString("title"), rs.getString("description"));
            }
        }
        return null;
    }

    public List<Film> findByName(String name) throws SQLException {
        List<Film> list = new ArrayList<>();
        String sql = "SELECT * FROM film WHERE title ILIKE ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Film(rs.getInt("film_id"), rs.getString("title"), rs.getString("description")));
            }
        }
        return list;
    }

    public void update(Film film) throws SQLException {
        String sql = "UPDATE film SET title = ?, description = ? WHERE film_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.setInt(3, film.getFilmId());
            stmt.executeUpdate();
            AuditLogger.log("UPDATE: " + film.getFilmId());
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM film WHERE film_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            AuditLogger.log("DELETE: " + id);
        }
    }
}
