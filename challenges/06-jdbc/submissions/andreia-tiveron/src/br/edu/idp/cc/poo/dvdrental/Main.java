package br.edu.idp.cc.poo.dvdrental;

import java.util.List;
import java.util.Scanner;

import br.edu.idp.cc.poo.dvdrental.dao.FilmDAO;
import br.edu.idp.cc.poo.dvdrental.model.Film;

public class Main {
    public static void main(String[] args) {
        FilmDAO dao = new FilmDAO();
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n1. Inserir Filme");
            System.out.println("2. Listar Filmes");
            System.out.println("3. Buscar Filme por ID");
            System.out.println("4. Buscar Filme por Título");
            System.out.println("5. Atualizar Filme");
            System.out.println("6. Remover Filme");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            op = sc.nextInt(); sc.nextLine();

            try {
                switch (op) {
                    case 1 -> {
                        System.out.print("Título: ");
                        String title = sc.nextLine();
                        System.out.print("Descrição: ");
                        String desc = sc.nextLine();
                        dao.insert(new Film(0, title, desc));
                    }
                    case 2 -> {
                        List<Film> list = dao.findAll();
                        list.forEach(System.out::println);
                    }
                    case 3 -> {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        Film f = dao.findById(id);
                        System.out.println(f != null ? f : "Filme não encontrado.");
                    }
                    case 4 -> {
                        System.out.print("Título: ");
                        String title = sc.nextLine();
                        List<Film> list = dao.findByTitle(title);
                        list.forEach(System.out::println);
                    }
                    case 5 -> {
                        System.out.print("ID: ");
                        int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Novo Título: ");
                        String title = sc.nextLine();
                        System.out.print("Nova Descrição: ");
                        String desc = sc.nextLine();
                        dao.update(new Film(id, title, desc));
                    }
                    case 6 -> {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        dao.delete(id);
                    }
                    case 0 -> System.out.println("Encerrando...");
                    default -> System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (op != 0);

        sc.close();
    }
}
