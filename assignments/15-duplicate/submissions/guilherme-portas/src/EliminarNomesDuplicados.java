import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.lang.String;
import java.util.Set;

public class EliminarNomesDuplicados {
    public static void main(String[] args) {
        Set<String> serieNomes = new TreeSet<String>();

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        try(Scanner scanner = new Scanner(System.in)) {
            while(true) {
                System.out.print("> ");
                String nome = scanner.nextLine();

                if(nome.equalsIgnoreCase("fim")) break;
                if(!setContainsIgnoreCase(serieNomes, nome)) {
                    serieNomes.add(nome);
                }
            }

            Iterator<String> it = serieNomes.iterator();

            System.out.println("\nNomes cadastrados:");
            System.out.print("[");
            while(it.hasNext()) {
                System.out.print(it.next() + (it.hasNext() ? ", " : ""));
            }

            System.out.println("]");

            System.out.println("\nPesquisar os nomes (digite 'sair' para encerrar):");
                while(true) {
                    System.out.print("> ");
                    String nomeAhPesquisar = scanner.nextLine();

                    if(nomeAhPesquisar.equalsIgnoreCase("sair")) break;
                    if(setContainsIgnoreCase(serieNomes, nomeAhPesquisar)) System.out.println("Nome encontrado.");
                    else System.out.println("Nome não encontrado.");
                }
        }
    }

    public static boolean setContainsIgnoreCase(Set<String> set, String searchStr) {
        if(set == null || searchStr == null) return false;

        Iterator<String> it = set.iterator();
        while(it.hasNext()) {
            String str = it.next();
            if (str.equalsIgnoreCase(searchStr))
                return true;
        }
        return false;
    }
}