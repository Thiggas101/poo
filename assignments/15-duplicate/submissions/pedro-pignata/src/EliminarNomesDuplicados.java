import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class EliminarNomesDuplicados {
    public static void main(String[] args) {
        Set<String> nomes = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        while (true) {
            System.out.print("> ");
            String entrada = scanner.nextLine().trim();
            
            if (entrada.equalsIgnoreCase("fim")) {
                break;
            }
            
            if (!entrada.isEmpty()) {
                String nomeFormatado = entrada.substring(0, 1).toUpperCase() + 
                                      entrada.substring(1).toLowerCase();
                nomes.add(nomeFormatado);
            }
        }

        System.out.println("\nNomes cadastrados:");
        Set<String> nomesOrdenados = new TreeSet<>(nomes);
        System.out.println(nomesOrdenados);
        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");
        while (true) {
            System.out.print("> ");
            String pesquisa = scanner.nextLine().trim();
            
            if (pesquisa.equalsIgnoreCase("sair")) {
                break;
            }
            
            if (!pesquisa.isEmpty()) {
                String nomePesquisa = pesquisa.substring(0, 1).toUpperCase() + 
                                     pesquisa.substring(1).toLowerCase();
                
                if (nomes.contains(nomePesquisa)) {
                    System.out.println("Nome encontrado.");
                } else {
                    System.out.println("Nome não encontrado.");
                }
            }
        }

        scanner.close();
    }
}