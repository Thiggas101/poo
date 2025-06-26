package br.edu.idp.cc.poo.dvdrental.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.idp.cc.poo.dvdrental.model.Film;
import br.edu.idp.cc.poo.dvdrental.util.AuditLogger;
import br.edu.idp.cc.poo.dvdrental.util.ConnectionFactory;

public class FilmDAO {

    public void inserir(Film filme) throws SQLException, IOException {
        String sql = "INSERT INTO film (title, description, release_year, language_id) VALUES (?, ?, ?, ?)";

        try (Connection conexao = ConnectionFactory.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, filme.getTitulo());
            stmt.setString(2, filme.getDescricao());
            stmt.setInt(3, filme.getAnoLancamento());
            stmt.setInt(4, filme.getIdiomaId());

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                AuditLogger.log("Inserido filme: " + filme.getTitulo());
            }
        }
    }

    public List<Film> listarTodos() throws SQLException, IOException {
        List<Film> filmes = new ArrayList<>();
        String sql = "SELECT film_id, title, description, release_year, language_id FROM film";

        try (Connection conexao = ConnectionFactory.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Film filme = new Film();
                filme.setFilmId(rs.getInt("film_id"));
                filme.setTitulo(rs.getString("title"));
                filme.setDescricao(rs.getString("description"));
                filme.setAnoLancamento(rs.getInt("release_year"));
                filme.setIdiomaId(rs.getInt("language_id"));

                filmes.add(filme);
            }
        }
        return filmes;
    }

    public Film buscarPorId(int id) throws SQLException, IOException {
        String sql = "SELECT film_id, title, description, release_year, language_id FROM film WHERE film_id = ?";
        Film filme = null;

        try (Connection conexao = ConnectionFactory.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    filme = new Film();
                    filme.setFilmId(rs.getInt("film_id"));
                    filme.setTitulo(rs.getString("title"));
                    filme.setDescricao(rs.getString("description"));
                    filme.setAnoLancamento(rs.getInt("release_year"));
                    filme.setIdiomaId(rs.getInt("language_id"));
                }
            }
        }
        return filme;
    }

    public List<Film> buscarPorTitulo(String titulo) throws SQLException, IOException {
        List<Film> filmes = new ArrayList<>();
        String sql = "SELECT film_id, title, description, release_year, language_id FROM film WHERE title ILIKE ?";

        try (Connection conexao = ConnectionFactory.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, "%" + titulo + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Film filme = new Film();
                    filme.setFilmId(rs.getInt("film_id"));
                    filme.setTitulo(rs.getString("title"));
                    filme.setDescricao(rs.getString("description"));
                    filme.setAnoLancamento(rs.getInt("release_year"));
                    filme.setIdiomaId(rs.getInt("language_id"));
                    filmes.add(filme);
                }
            }
        }
        return filmes;
    }

    public void atualizar(Film filme) throws SQLException, IOException {
        String sql = "UPDATE film SET title = ?, description = ?, release_year = ?, language_id = ? WHERE film_id = ?";

        try (Connection conexao = ConnectionFactory.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, filme.getTitulo());
            stmt.setString(2, filme.getDescricao());
            stmt.setInt(3, filme.getAnoLancamento());
            stmt.setInt(4, filme.getIdiomaId());
            stmt.setInt(5, filme.getFilmId());

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                AuditLogger.log("Atualizado filme ID: " + filme.getFilmId());
            }
        }
    }

    public void remover(int id) throws SQLException, IOException {
        String sql = "DELETE FROM film WHERE film_id = ?";

        try (Connection conexao = ConnectionFactory.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                AuditLogger.log("Removido filme ID: " + id);
            }
        }
    }
}
