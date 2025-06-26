package br.edu.idp.cc.poo.dvdrental;

import br.edu.idp.cc.poo.dvdrental.dao.ActorDAO;
import br.edu.idp.cc.poo.dvdrental.dao.FilmDAO;
import br.edu.idp.cc.poo.dvdrental.model.Actor;
import br.edu.idp.cc.poo.dvdrental.model.Film;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilmDAO filmDAO = new FilmDAO();
        ActorDAO actorDAO = new ActorDAO();
        while (true) {
            System.out.println("1-Inserir filme  2-Buscar filme por ID  3-Buscar filme por nome");
            System.out.println("4-Listar atores  5-Atualizar ator  6-Remover ator  0-Sair");
            int op = sc.nextInt();
            sc.nextLine();
            try {
                if (op == 1) {
                    System.out.print("Título: ");
                    String t = sc.nextLine();
                    System.out.print("Descrição: ");
                    String d = sc.nextLine();
                    System.out.print("Ano: ");
                    int y = sc.nextInt();
                    System.out.print("Language ID: ");
                    int l = sc.nextInt();
                    sc.nextLine();
                    filmDAO.insert(new Film(0, t, d, y, l));
                } else if (op == 2) {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Film f = filmDAO.findById(id);
                    System.out.println(f != null ? f.getTitle() + " - " + f.getDescription() : "Não encontrado");
                } else if (op == 3) {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    List<Film> filmes = filmDAO.findByTitle(nome);
                    filmes.forEach(fm -> System.out.println(fm.getFilmId() + ": " + fm.getTitle()));
                } else if (op == 4) {
                    List<Actor> atores = actorDAO.findAll();
                    atores.forEach(a -> System.out.println(a.getActorId() + ": " + a.getFirstName() + " " + a.getLastName()));
                } else if (op == 5) {
                    System.out.print("ID do ator: ");
                    int aid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo primeiro nome: ");
                    String fn = sc.nextLine();
                    System.out.print("Novo último nome: ");
                    String ln = sc.nextLine();
                    Actor at = new Actor(aid, fn, ln);
                    actorDAO.update(at);
                } else if (op == 6) {
                    System.out.print("ID do ator: ");
                    int aid2 = sc.nextInt();
                    sc.nextLine();
                    actorDAO.delete(aid2);
                } else if (op == 0) {
                    break;
                }
            } catch (Exception e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }
        sc.close();
    }
}
