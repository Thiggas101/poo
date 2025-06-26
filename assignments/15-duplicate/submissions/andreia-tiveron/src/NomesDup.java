import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class NomesDup{
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
                nomes.add(maiuscula(entrada)); 
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

            boolean encontrado = nomes.stream()
                .anyMatch(nome -> nome.equalsIgnoreCase(busca));

            if (encontrado) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        scanner.close();
    }
    private static String maiuscula(String nome) {
    if (nome.isEmpty()) return nome;
    return nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
    }

}
