// src/main/java/br/edu/idp/cc/poo/dvdrental/Main.java
package br.edu.idp.cc.poo.dvdrental;

import br.edu.idp.cc.poo.dvdrental.dao.ActorDAO;
import br.edu.idp.cc.poo.dvdrental.dao.FilmDAO;
import br.edu.idp.cc.poo.dvdrental.model.Actor;
import br.edu.idp.cc.poo.dvdrental.model.Film;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final FilmDAO filmDAO = new FilmDAO();
    private static final ActorDAO actorDAO = new ActorDAO();

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\n=== MENU DVD Rental ===");
                System.out.println("1. Inserir novo filme");
                System.out.println("2. Listar todos os atores");
                System.out.println("3. Buscar filme por ID");
                System.out.println("4. Buscar filme por nome");
                System.out.println("5. Atualizar ator");
                System.out.println("6. Remover ator");
                System.out.println("0. Sair");
                System.out.print("Opção: ");
                int op = Integer.parseInt(sc.nextLine());

                switch (op) {
                    case 1: insertFilm(); break;
                    case 2: listActors(); break;
                    case 3: findFilmById(); break;
                    case 4: findFilmByName(); break;
                    case 5: updateActor(); break;
                    case 6: deleteActor(); break;
                    case 0: System.out.println("Saindo..."); System.exit(0);
                    default: System.out.println("Opção inválida.");
                }
            } catch (SQLException e) {
                System.err.println("Erro de banco: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("Entrada inválida. Use apenas números.");
            }
        }
    }

    private static void insertFilm() throws SQLException {
        System.out.print("Título: ");
        String title = sc.nextLine();
        System.out.print("Descrição: ");
        String desc = sc.nextLine();
        System.out.print("Ano de lançamento: ");
        int year = Integer.parseInt(sc.nextLine());
        System.out.print("ID de idioma: ");
        int lang = Integer.parseInt(sc.nextLine());
        System.out.print("Duração (dias): ");
        int dur = Integer.parseInt(sc.nextLine());
        System.out.print("Tarifa: ");
        BigDecimal rate = new BigDecimal(sc.nextLine());
        System.out.print("Comprimento (min): ");
        int length = Integer.parseInt(sc.nextLine());
        System.out.print("Custo reposição: ");
        BigDecimal cost = new BigDecimal(sc.nextLine());
        System.out.print("Classificação: ");
        String rating = sc.nextLine();
        System.out.print("Recursos especiais (csv): ");
        String feat = sc.nextLine();

        Film film = new Film(title, desc, year, lang, dur, rate, length, cost, rating, feat);
        Film inserted = filmDAO.insertFilm(film);
        System.out.println("Inserido com ID: " + inserted.getFilmId());
    }

    private static void listActors() throws SQLException {
        List<Actor> atores = actorDAO.listAllActors();
        if (atores.isEmpty()) {
            System.out.println("Nenhum ator encontrado.");
        } else {
            atores.forEach(a -> System.out.println(a));
        }
    }

    private static void findFilmById() throws SQLException {
        System.out.print("ID do filme: ");
        int id = Integer.parseInt(sc.nextLine());
        Film f = filmDAO.getFilmById(id);
        System.out.println(f != null ? f : "Filme não encontrado.");
    }

    private static void findFilmByName() throws SQLException {
        System.out.print("Nome (ou parte): ");
        String nome = sc.nextLine();
        List<Film> list = filmDAO.getFilmsByName(nome);
        if (list.isEmpty()) {
            System.out.println("Nenhum filme encontrado.");
        } else {
            list.forEach(f -> System.out.println(f));
        }
    }

    private static void updateActor() throws SQLException {
        System.out.print("ID do ator: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Novo primeiro nome: ");
        String fn = sc.nextLine();
        System.out.print("Novo último nome: ");
        String ln = sc.nextLine();
        Actor actor = new Actor(id, fn, ln);
        actorDAO.updateActor(actor);
        System.out.println("Ator atualizado.");
    }

    private static void deleteActor() throws SQLException {
        System.out.print("ID do ator a remover: ");
        int id = Integer.parseInt(sc.nextLine());
        actorDAO.deleteActor(id);
        System.out.println("Ator removido.");
    }
}
