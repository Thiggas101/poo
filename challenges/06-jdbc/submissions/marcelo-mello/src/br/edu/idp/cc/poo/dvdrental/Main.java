package br.edu.idp.cc.poo.dvdrental;

import br.edu.idp.cc.poo.dvdrental.dao.FilmDAO;
import br.edu.idp.cc.poo.dvdrental.model.Film;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final FilmDAO filmDAO = new FilmDAO();

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n🎬 MENU DVD RENTAL");
            System.out.println("1. Inserir novo filme");
            System.out.println("2. Listar todos os filmes");
            System.out.println("3. Buscar filme por ID");
            System.out.println("4. Buscar filme por título");
            System.out.println("5. Atualizar filme");
            System.out.println("6. Remover filme");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir \n

            try {
                switch (opcao) {
                    case 1 -> inserirFilme();
                    case 2 -> listarFilmes();
                    case 3 -> buscarPorId();
                    case 4 -> buscarPorTitulo();
                    case 5 -> atualizarFilme();
                    case 6 -> removerFilme();
                    case 0 -> System.out.println("Encerrando...");
                    default -> System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.err.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);
    }

    private static void inserirFilme() throws Exception {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        Film novo = new Film(0, titulo, descricao);
        filmDAO.insert(novo);
        System.out.println("Filme inserido com sucesso!");
    }

    private static void listarFilmes() throws Exception {
        List<Film> filmes = filmDAO.findAll();
        filmes.forEach(System.out::println);
    }

    private static void buscarPorId() throws Exception {
        System.out.print("ID do filme: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Film f = filmDAO.findById(id);
        if (f != null) {
            System.out.println(f);
        } else {
            System.out.println("Filme não encontrado.");
        }
    }

    private static void buscarPorTitulo() throws Exception {
        System.out.print("Título (ou parte): ");
        String titulo = scanner.nextLine();

        List<Film> filmes = filmDAO.findByTitle(titulo);
        filmes.forEach(System.out::println);
    }

    private static void atualizarFilme() throws Exception {
        System.out.print("ID do filme a atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Film f = filmDAO.findById(id);
        if (f == null) {
            System.out.println("Filme não encontrado.");
            return;
        }

        System.out.print("Novo título: ");
        String novoTitulo = scanner.nextLine();
        System.out.print("Nova descrição: ");
        String novaDescricao = scanner.nextLine();

        f.setTitle(novoTitulo);
        f.setDescription(novaDescricao);

        filmDAO.update(f);
        System.out.println("Filme atualizado.");
    }

    private static void removerFilme() throws Exception {
        System.out.print("ID do filme a remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        filmDAO.delete(id);
        System.out.println("Filme removido.");
    }
}
