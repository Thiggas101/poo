package br.edu.idp.cc.poo.dvdrental;

import java.sql.SQLException;
import java.time.Year;
import java.util.List;
import java.util.Scanner;

import br.edu.idp.cc.poo.dvdrental.dao.FilmDAO;
import br.edu.idp.cc.poo.dvdrental.model.Film;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final FilmDAO filmDAO = new FilmDAO();

    public static void main(String[] args) {
        System.out.println("📀 DVD Rental Manager 📀");
        
        while (true) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Cadastrar novo filme");
            System.out.println("2. Listar todos os filmes");
            System.out.println("3. Buscar filme por ID");
            System.out.println("4. Atualizar filme");
            System.out.println("5. Remover filme");
            System.out.println("6. Sair");
            System.out.print("Escolha: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa buffer
            
            try {
                switch (opcao) {
                    case 1 -> cadastrarFilme();
                    case 2 -> listarFilmes();
                    case 3 -> buscarPorId();
                    case 4 -> atualizarFilme();
                    case 5 -> removerFilme();
                    case 6 -> { 
                        System.out.println("Até logo! 👋");
                        return; 
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (SQLException e) {
                System.out.println("Erro no banco: " + e.getMessage());
            }
        }
    }

    private static void cadastrarFilme() throws SQLException {
        Film filme = new Film();
        
        System.out.print("\nTítulo do filme: ");
        filme.setTitle(scanner.nextLine());
        
        System.out.print("Descrição: ");
        filme.setDescription(scanner.nextLine());
        
        System.out.print("Ano de lançamento: ");
        filme.setReleaseYear(Year.of(scanner.nextInt()));
        scanner.nextLine();
        
        filmDAO.insert(filme);
        System.out.println("✅ Filme cadastrado com ID: " + filme.getId());
    }

    private static void listarFilmes() throws SQLException {
        List<Film> filmes = filmDAO.findAll();
        
        if (filmes.isEmpty()) {
            System.out.println("\nNenhum filme cadastrado.");
        } else {
            System.out.println("\n📜 Lista de Filmes:");
            filmes.forEach(System.out::println);
            System.out.println("Total: " + filmes.size() + " filmes");
        }
    }

    private static void buscarPorId() throws SQLException {
        System.out.print("\nID do filme: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Film filme = filmDAO.findById(id);
        
        if (filme != null) {
            System.out.println("\n🎬 Filme encontrado:");
            System.out.println(filme);
            System.out.println("Descrição: " + filme.getDescription());
        } else {
            System.out.println("Filme não encontrado com ID: " + id);
        }
    }

    private static void atualizarFilme() throws SQLException {
        System.out.print("\nID do filme para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Film filme = filmDAO.findById(id);
        if (filme == null) {
            System.out.println("Filme não encontrado!");
            return;
        }
        
        System.out.println("\nEditando: " + filme);
        
        System.out.print("Novo título [" + filme.getTitle() + "]: ");
        String titulo = scanner.nextLine();
        if (!titulo.isEmpty()) filme.setTitle(titulo);
        
        System.out.print("Nova descrição [" + filme.getDescription() + "]: ");
        String desc = scanner.nextLine();
        if (!desc.isEmpty()) filme.setDescription(desc);
        
        System.out.print("Novo ano [" + filme.getReleaseYear() + "]: ");
        String anoStr = scanner.nextLine();
        if (!anoStr.isEmpty()) filme.setReleaseYear(Year.of(Integer.parseInt(anoStr)));
        
        if (filmDAO.update(filme)) {
            System.out.println("✅ Filme atualizado!");
        } else {
            System.out.println("❌ Falha ao atualizar!");
        }
    }

    private static void removerFilme() throws SQLException {
        System.out.print("\nID do filme para remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        if (filmDAO.delete(id)) {
            System.out.println("✅ Filme removido!");
        } else {
            System.out.println("❌ Filme não encontrado!");
        }
    }
}