// Nome: Allan Samuel Alves do Monte
// Matrícula: 24101279

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Duplicados {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> nomes = new TreeSet<>();

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        while (true) {
            String entrada = scanner.nextLine().trim();
            if (entrada.equalsIgnoreCase("fim")) {
                break;
            }
            if (!entrada.isEmpty()) {
                nomes.add(capitalizar(entrada.toLowerCase()));
            }
        }

        System.out.println("\nNomes cadastrados:");
        System.out.println(nomes);

        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");

        while (true) {
            String busca = scanner.nextLine().trim();
            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            String nomeFormatado = capitalizar(busca.toLowerCase());
            if (nomes.contains(nomeFormatado)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        scanner.close();
    }

    private static String capitalizar(String nome) {
        if (nome == null || nome.isEmpty()) return nome;
        return nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
    }
}
