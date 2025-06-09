package br.edu.idp.cc.poo.dvdrental;

import br.edu.idp.cc.poo.dvdrental.dao.FilmDAO;
import br.edu.idp.cc.poo.dvdrental.model.Film;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FilmDAO dao = new FilmDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- DVD Rental ---");
            System.out.println("1. Inserir Filme");
            System.out.println("2. Buscar Filme por ID");
            System.out.println("3. Buscar Filme por Título");
            System.out.println("4. Atualizar Descrição");
            System.out.println("5. Remover Filme");
            System.out.println("0. Sair");
            int op = sc.nextInt();
            sc.nextLine();

            try {
                switch (op) {
                    case 1 -> {
                        System.out.print("Título: ");
                        String titulo = sc.nextLine();
                        System.out.print("Descrição: ");
                        String desc = sc.nextLine();
                        dao.insert(new Film(0, titulo, desc));
                    }
                    case 2 -> {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        Film film = dao.findById(id);
                        System.out.println(film != null ? film : "Não encontrado.");
                    }
                    case 3 -> {
                        System.out.print("Título: ");
                        String titulo = sc.nextLine();
                        List<Film> filmes = dao.findByTitle(titulo);
                        filmes.forEach(System.out::println);
                    }
                    case 4 -> {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nova descrição: ");
                        String nova = sc.nextLine();
                        dao.updateDescription(id, nova);
                    }
                    case 5 -> {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        dao.delete(id);
                    }
                    case 0 -> {
                        sc.close();
                        return;
                    }
                    default -> System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
