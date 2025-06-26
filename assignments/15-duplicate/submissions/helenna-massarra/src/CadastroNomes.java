import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CadastroNomes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> nomes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        while(true) {
            System.out.print("> ");
            String entrada = scanner.nextLine().trim();

            if(entrada.equalsIgnoreCase("fim")) {
                break;
            }
            if (!entrada.isEmpty()) {
                nomes.add(capitalize(entrada));
            }
        }

        System.out.println("\nNomes cadastrados:");
        System.out.println(nomes);

        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");
        while (true) {
            System.out.print("> ");
            String pesquisa = scanner.nextLine().trim();
            if (pesquisa.equalsIgnoreCase("sair")) {
                break;
            }
            if (nomes.stream().anyMatch(nome -> nome.equalsIgnoreCase(pesquisa))) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        scanner.close();
    }

    private static String capitalize(String nome) {
        if (nome == null || nome.isEmpty()) {
            return nome;
        }
        return nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
    }
}
