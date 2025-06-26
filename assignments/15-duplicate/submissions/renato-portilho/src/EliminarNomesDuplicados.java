import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class EliminarNomesDuplicados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> nomes = new TreeSet<>();

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        while (true) {
            System.out.print("> ");
            String entrada = scanner.nextLine().trim();
            if (entrada.equalsIgnoreCase("fim")) {
                break;
            }
            if (!entrada.isEmpty()) {
                nomes.add(NomePadrao(entrada));
            }
        }

        System.out.println("\nNomes cadastrados:");
        System.out.println(nomes);

        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");
        while (true) {
            System.out.print("> ");
            String busca = scanner.nextLine().trim();
            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            String nomeBuscado = NomePadrao(busca);
            if (nomes.contains(nomeBuscado)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

    }

    private static String NomePadrao(String nome) {
        if (nome.isEmpty()) {
            return nome;

        } else {
            return nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
        }
    }
}
