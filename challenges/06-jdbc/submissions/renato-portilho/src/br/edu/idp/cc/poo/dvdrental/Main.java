package br.edu.idp.cc.poo.dvdrental;

import br.edu.idp.cc.poo.dvdrental.dao.FilmDAO;
import br.edu.idp.cc.poo.dvdrental.model.Film;
import br.edu.idp.cc.poo.dvdrental.util.ConnectionFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final FilmDAO filmDAO = new FilmDAO();

    public static void main(String[] args) {
        System.out.println("Testando conexão com o banco...");
        ConnectionFactory.testarConexao();

        boolean sair = false;

        while (!sair) {
            mostrarMenu();
            int opcao = lerInteiro("Opção: ");

            try {
                switch (opcao) {
                    case 1 -> inserirFilme();
                    case 2 -> listarFilmes();
                    case 3 -> buscarFilmePorId();
                    case 4 -> buscarFilmePorTitulo();
                    case 5 -> atualizarFilme();
                    case 6 -> removerFilme();
                    case 0 -> {
                        sair = true;
                        System.out.println("Saindo...");
                    }
                    default -> System.out.println("Opção inválida.");
                }
            } catch (SQLException | IOException e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n=== MENU FILMES ===");
        System.out.println("1. Inserir novo filme");
        System.out.println("2. Listar todos os filmes");
        System.out.println("3. Buscar filme por ID");
        System.out.println("4. Buscar filme por título");
        System.out.println("5. Atualizar filme");
        System.out.println("6. Remover filme por ID");
        System.out.println("0. Sair");
    }

    private static void inserirFilme() throws SQLException, IOException {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        int ano = lerInteiro("Ano de lançamento: ");

        int idiomaId = lerInteiro("ID do idioma: ");

        Film filme = new Film(0, titulo, descricao, ano, idiomaId);

        filmDAO.inserir(filme);
        System.out.println("Filme inserido com sucesso!");
    }

    private static void listarFilmes() throws SQLException, IOException {
        List<Film> filmes = filmDAO.listarTodos();
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme encontrado.");
            return;
        }
        System.out.println("\nLista de filmes:");
        for (Film f : filmes) {
            System.out.printf("ID: %d | Título: %s | Ano: %d | Idioma ID: %d\n",
                    f.getFilmId(), f.getTitulo(), f.getAnoLancamento(), f.getIdiomaId());
        }
    }

    private static void buscarFilmePorId() throws SQLException, IOException {
        int id = lerInteiro("ID do filme: ");
        Film filme = filmDAO.buscarPorId(id);
        if (filme == null) {
            System.out.println("Filme não encontrado.");
        } else {
            System.out.printf("ID: %d | Título: %s | Descrição: %s | Ano: %d | Idioma ID: %d\n",
                    filme.getFilmId(), filme.getTitulo(), filme.getDescricao(),
                    filme.getAnoLancamento(), filme.getIdiomaId());
        }
    }

    private static void buscarFilmePorTitulo() throws SQLException, IOException {
        System.out.print("Parte do título: ");
        String titulo = scanner.nextLine();

        List<Film> filmes = filmDAO.buscarPorTitulo(titulo);

        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme encontrado.");
            return;
        }

        System.out.println("\nFilmes encontrados:");
        for (Film f : filmes) {
            System.out.printf("ID: %d | Título: %s | Ano: %d | Idioma ID: %d\n",
                    f.getFilmId(), f.getTitulo(), f.getAnoLancamento(), f.getIdiomaId());
        }
    }

    private static void atualizarFilme() throws SQLException, IOException {
        int id = lerInteiro("ID do filme para atualizar: ");

        Film filme = filmDAO.buscarPorId(id);
        if (filme == null) {
            System.out.println("Filme não encontrado.");
            return;
        }

        System.out.printf("Título atual (%s): ", filme.getTitulo());
        String titulo = scanner.nextLine();
        if (!titulo.trim().isEmpty()) filme.setTitulo(titulo);

        System.out.printf("Descrição atual (%s): ", filme.getDescricao());
        String descricao = scanner.nextLine();
        if (!descricao.trim().isEmpty()) filme.setDescricao(descricao);

        System.out.printf("Ano atual (%d): ", filme.getAnoLancamento());
        String anoStr = scanner.nextLine();
        if (!anoStr.trim().isEmpty()) filme.setAnoLancamento(Integer.parseInt(anoStr));

        System.out.printf("Idioma ID atual (%d): ", filme.getIdiomaId());
        String idiomaStr = scanner.nextLine();
        if (!idiomaStr.trim().isEmpty()) filme.setIdiomaId(Integer.parseInt(idiomaStr));

        filmDAO.atualizar(filme);
        System.out.println("Filme atualizado com sucesso!");
    }

    private static void removerFilme() throws SQLException, IOException {
        int id = lerInteiro("ID do filme para remover: ");
        filmDAO.remover(id);
        System.out.println("Filme removido, se existia.");
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String linha = scanner.nextLine();
            try {
                return Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, digite um número inteiro.");
            }
        }
    }
}
