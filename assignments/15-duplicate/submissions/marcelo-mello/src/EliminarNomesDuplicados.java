import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class EliminarNomesDuplicados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> nomes = new TreeSet<>();

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        while (true) {
            String entrada = scanner.nextLine().trim();
            if (entrada.equalsIgnoreCase("fim")) {
                break;
            }
            
            String nomeFormatado = entrada.substring(0, 1).toUpperCase() + entrada.substring(1).toLowerCase();
            nomes.add(nomeFormatado);
        }

        System.out.println("\nNomes cadastrados:");
        System.out.println(nomes);

        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");
        while (true) {
            String pesquisa = scanner.nextLine().trim();
            if (pesquisa.equalsIgnoreCase("sair")) {
                break;
            }
            String pesquisaFormatada = pesquisa.substring(0, 1).toUpperCase() + pesquisa.substring(1).toLowerCase();
            if (nomes.contains(pesquisaFormatada)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        scanner.close();
    }
}
