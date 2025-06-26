package br.edu.idp.cc.poo.dvdrental;

import br.edu.idp.cc.poo.dvdrental.dao.*;
import br.edu.idp.cc.poo.dvdrental.model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilmDAO filmDAO = new FilmDAO();
        ActorDAO actorDAO = new ActorDAO();

        while (true) {
            System.out.println("\n1 - Inserir filme");
            System.out.println("2 - Buscar filme por ID");
            System.out.println("3 - Buscar filme por nome");
            System.out.println("4 - Listar todos os atores");
            System.out.println("5 - Atualizar ator");
            System.out.println("6 - Remover ator");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = sc.nextLine();
                    filmDAO.insert(new Film(titulo, descricao));
                }
                case 2 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    Film f = filmDAO.findById(id);
                    if (f != null)
                        System.out.println(f.getTitle() + ": " + f.getDescription());
                    else
                        System.out.println("Filme não encontrado.");
                }
                case 3 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    filmDAO.findByTitle(nome);
                }
                case 4 -> actorDAO.listAll();
                case 5 -> {
                    System.out.print("ID do ator: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Novo primeiro nome: ");
                    String fn = sc.nextLine();
                    System.out.print("Novo sobrenome: ");
                    String ln = sc.nextLine();
                    actorDAO.update(id, fn, ln);
                }
                case 6 -> {
                    System.out.print("ID do ator a remover: ");
                    int id = sc.nextInt();
                    actorDAO.delete(id);
                }
                case 0 -> {
                    System.out.println("Encerrando.");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
