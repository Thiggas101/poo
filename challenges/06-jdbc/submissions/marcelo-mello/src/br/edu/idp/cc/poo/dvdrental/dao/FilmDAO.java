package br.edu.idp.cc.poo.dvdrental.dao;

import br.edu.idp.cc.poo.dvdrental.model.Film;
import br.edu.idp.cc.poo.dvdrental.util.ConnectionFactory;
import br.edu.idp.cc.poo.dvdrental.util.AuditLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {

    public void insert(Film film) throws Exception {
        String sql = "INSERT INTO film (title, description, language_id) VALUES (?, ?, 1)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.executeUpdate();

            AuditLogger.log("INSERT: " + film.getTitle());
        }
    }

    public Film findById(int id) throws Exception {
        String sql = "SELECT film_id, title, description FROM film WHERE film_id = ?";
        Film film = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                film = new Film(
                    rs.getInt("film_id"),
                    rs.getString("title"),
                    rs.getString("description")
                );
            }
        }
        return film;
    }

    public List<Film> findByTitle(String title) throws Exception {
        String sql = "SELECT film_id, title, description FROM film WHERE title ILIKE ?";
        List<Film> films = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + title + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                films.add(new Film(
                    rs.getInt("film_id"),
                    rs.getString("title"),
                    rs.getString("description")
                ));
            }
        }
        return films;
    }

    public List<Film> findAll() throws Exception {
        String sql = "SELECT film_id, title, description FROM film";
        List<Film> films = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                films.add(new Film(
                    rs.getInt("film_id"),
                    rs.getString("title"),
                    rs.getString("description")
                ));
            }
        }
        return films;
    }

    public void update(Film film) throws Exception {
        String sql = "UPDATE film SET title = ?, description = ? WHERE film_id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.setInt(3, film.getFilmId());
            stmt.executeUpdate();

            AuditLogger.log("UPDATE: " + film.getTitle());
        }
    }

    public void delete(int id) throws Exception {
        String sql = "DELETE FROM film WHERE film_id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            AuditLogger.log("DELETE: Film ID " + id);
        }
    }
}
