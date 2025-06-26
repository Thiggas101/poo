package br.edu.idp.cc.poo.dvdrental.dao;

import br.edu.idp.cc.poo.dvdrental.model.Film;
import br.edu.idp.cc.poo.dvdrental.util.AuditLogger;
import br.edu.idp.cc.poo.dvdrental.util.ConnectionFactory;

import java.sql.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {

    // Create
    public void insert(Film film) throws SQLException {
        String sql = "INSERT INTO film (title, description, release_year) VALUES (?, ?, ?)";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.setInt(3, film.getReleaseYear().getValue());
            
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    film.setId(rs.getInt(1));
                    AuditLogger.log("INSERT", "Novo filme: " + film.getTitle());
                }
            }
        }
    }

    // Read (todos)
    public List<Film> findAll() throws SQLException {
        List<Film> films = new ArrayList<>();
        String sql = "SELECT film_id, title, description, release_year FROM film";
        
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Film film = new Film();
                film.setId(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setReleaseYear(Year.of(rs.getInt("release_year")));
                films.add(film);
            }
        }
        return films;
    }

    // Read (por ID)
    public Film findById(int id) throws SQLException {
        String sql = "SELECT film_id, title, description, release_year FROM film WHERE film_id = ?";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Film film = new Film();
                    film.setId(rs.getInt("film_id"));
                    film.setTitle(rs.getString("title"));
                    film.setDescription(rs.getString("description"));
                    film.setReleaseYear(Year.of(rs.getInt("release_year")));
                    return film;
                }
            }
        }
        return null;
    }

    // Update
    public boolean update(Film film) throws SQLException {
        String sql = "UPDATE film SET title = ?, description = ?, release_year = ? WHERE film_id = ?";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.setInt(3, film.getReleaseYear().getValue());
            stmt.setInt(4, film.getId());
            
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                AuditLogger.log("UPDATE", "Filme atualizado: " + film.getId());
                return true;
            }
            return false;
        }
    }

    // Delete
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM film WHERE film_id = ?";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                AuditLogger.log("DELETE", "Filme removido: " + id);
                return true;
            }
            return false;
        }
    }
}