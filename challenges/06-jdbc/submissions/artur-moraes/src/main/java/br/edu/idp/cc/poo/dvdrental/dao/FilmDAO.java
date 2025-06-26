// src/main/java/br/edu/idp/cc/poo/dvdrental/dao/FilmDAO.java
package br.edu.idp.cc.poo.dvdrental.dao;

import br.edu.idp.cc.poo.dvdrental.model.Film;
import br.edu.idp.cc.poo.dvdrental.util.AuditLogger;
import br.edu.idp.cc.poo.dvdrental.util.ConnectionFactory;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {

    public Film insertFilm(Film film) throws SQLException {
        String sql = "INSERT INTO film (title, description, release_year, language_id, " +
                     "rental_duration, rental_rate, length, replacement_cost, rating, special_features) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING film_id";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, film.getTitle());
            ps.setString(2, film.getDescription());
            ps.setInt(3, film.getReleaseYear());
            ps.setInt(4, film.getLanguageId());
            ps.setInt(5, film.getRentalDuration());
            ps.setBigDecimal(6, film.getRentalRate());
            ps.setInt(7, film.getLength());
            ps.setBigDecimal(8, film.getReplacementCost());
            ps.setString(9, film.getRating());
            ps.setString(10, film.getSpecialFeatures());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    film.setFilmId(rs.getInt("film_id"));
                }
            }
            AuditLogger.log("INSERT_FILM", film.toString());
            return film;
        }
    }

    public Film getFilmById(int id) throws SQLException {
        String sql = "SELECT * FROM film WHERE film_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRowToFilm(rs);
                } else {
                    return null;
                }
            }
        }
    }

    public List<Film> getFilmsByName(String name) throws SQLException {
        String sql = "SELECT * FROM film WHERE title ILIKE ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                List<Film> list = new ArrayList<>();
                while (rs.next()) {
                    list.add(mapRowToFilm(rs));
                }
                return list;
            }
        }
    }

    private Film mapRowToFilm(ResultSet rs) throws SQLException {
        Film f = new Film();
        f.setFilmId(rs.getInt("film_id"));
        f.setTitle(rs.getString("title"));
        f.setDescription(rs.getString("description"));
        f.setReleaseYear(rs.getInt("release_year"));
        f.setLanguageId(rs.getInt("language_id"));
        f.setRentalDuration(rs.getInt("rental_duration"));
        f.setRentalRate(rs.getBigDecimal("rental_rate"));
        f.setLength(rs.getInt("length"));
        f.setReplacementCost(rs.getBigDecimal("replacement_cost"));
        f.setRating(rs.getString("rating"));
        f.setSpecialFeatures(rs.getString("special_features"));
        return f;
    }
}
