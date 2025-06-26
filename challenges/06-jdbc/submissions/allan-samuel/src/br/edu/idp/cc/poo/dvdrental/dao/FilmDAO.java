package br.edu.idp.cc.poo.dvdrental.dao;

import br.edu.idp.cc.poo.dvdrental.model.Film;
import br.edu.idp.cc.poo.dvdrental.util.ConnectionFactory;
import br.edu.idp.cc.poo.dvdrental.util.AuditLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {

    public void insertFilm(Film film) {
        String sql = "INSERT INTO film (title, description, language_id) VALUES (?, ?, 1)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.executeUpdate();
            AuditLogger.log("Inserido filme: " + film.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Film findFilmById(int id) {
        String sql = "SELECT film_id, title, description FROM film WHERE film_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Film(rs.getInt("film_id"), rs.getString("title"), rs.getString("description"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Film> findFilmByName(String name) {
        List<Film> filmes = new ArrayList<>();
        String sql = "SELECT film_id, title, description FROM film WHERE title ILIKE ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                filmes.add(new Film(rs.getInt("film_id"), rs.getString("title"), rs.getString("description")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filmes;
    }

    public void listActors() {
        String sql = "SELECT actor_id, first_name, last_name FROM actor ORDER BY actor_id";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println(rs.getInt("actor_id") + ": " + rs.getString("first_name") + " " + rs.getString("last_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateActor(int actorId, String newFirstName, String newLastName) {
        String sql = "UPDATE actor SET first_name = ?, last_name = ? WHERE actor_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newFirstName);
            stmt.setString(2, newLastName);
            stmt.setInt(3, actorId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                AuditLogger.log("Atualizado ator ID: " + actorId);
                System.out.println("Ator atualizado.");
            } else {
                System.out.println("Ator não encontrado.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteActor(int actorId) {
        String sql = "DELETE FROM actor WHERE actor_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, actorId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                AuditLogger.log("Removido ator ID: " + actorId);
                System.out.println("Ator removido.");
            } else {
                System.out.println("Ator não encontrado.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
