package br.edu.idp.cc.poo.dvdrental;

import br.edu.idp.cc.poo.dvdrental.dao.FilmDAO;
import br.edu.idp.cc.poo.dvdrental.model.Film;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        FilmDAO dao = new FilmDAO();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("""
                1 - Inserir novo filme
                2 - Listar todos os filmes
                3 - Buscar por ID
                4 - Buscar por nome
                5 - Atualizar filme
                6 - Remover filme
                0 - Sair
                """);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    dao.insert(new Film(0, titulo, desc));
                }
                case 2 -> {
                    List<Film> filmes = dao.findAll();
                    filmes.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("ID: ");
                    Film f = dao.findById(sc.nextInt());
                    System.out.println(f != null ? f : "Não encontrado");
                }
                case 4 -> {
                    System.out.print("Nome: ");
                    List<Film> list = dao.findByName(sc.nextLine());
                    list.forEach(System.out::println);
                }
                case 5 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Novo título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Nova descrição: ");
                    String desc = sc.nextLine();
                    dao.update(new Film(id, titulo, desc));
                }
                case 6 -> {
                    System.out.print("ID: ");
                    dao.delete(sc.nextInt());
                }
            }
        } while (opcao != 0);
        sc.close();
    }
}
