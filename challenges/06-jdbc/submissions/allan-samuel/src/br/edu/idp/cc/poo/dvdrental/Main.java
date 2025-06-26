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
            System.out.println("\n--- MENU ---");
            System.out.println("1. Inserir novo filme");
            System.out.println("2. Buscar filme por ID");
            System.out.println("3. Buscar filme por nome");
            System.out.println("4. Listar todos os atores");
            System.out.println("5. Atualizar ator");
            System.out.println("6. Remover ator por ID");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1 -> {
                    System.out.print("Título: ");
                    String title = sc.nextLine();
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    dao.insertFilm(new Film(0, title, desc));
                }
                case 2 -> {
                    System.out.print("ID do filme: ");
                    int id = sc.nextInt();
                    Film film = dao.findFilmById(id);
                    System.out.println(film != null ? film : "Filme não encontrado.");
                }
                case 3 -> {
                    System.out.print("Nome do filme: ");
                    String name = sc.nextLine();
                    List<Film> filmes = dao.findFilmByName(name);
                    filmes.forEach(System.out::println);
                }
                case 4 -> dao.listActors();
                case 5 -> {
                    System.out.print("ID do ator: ");
                    int actorId = sc.nextInt(); sc.nextLine();
                    System.out.print("Novo primeiro nome: ");
                    String fname = sc.nextLine();
                    System.out.print("Novo sobrenome: ");
                    String lname = sc.nextLine();
                    dao.updateActor(actorId, fname, lname);
                }
                case 6 -> {
                    System.out.print("ID do ator: ");
                    int actorId = sc.nextInt();
                    dao.deleteActor(actorId);
                }
                case 0 -> {
                    System.out.println("Encerrando...");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
