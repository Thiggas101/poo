import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class duplicate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> nomes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER); //case insensitive ja no treeset pra nem precisar pensar

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        while(true){
            System.out.print("> ");
            String nome = scan.nextLine().trim();
            if(nome.equalsIgnoreCase("fim")){ // toda versao de 'fim' vale
                break;
            }
            if(!nome.isEmpty()){
                nomes.add(nome);
            }
        }

        System.out.println("\nNomes cadastrados:");
        System.out.println(nomes);
        System.out.println("\nPesquisar nomes(digite 'sair' para encerrar):");
        while(true){
            System.out.print("> ");
            String busca = scan.nextLine().trim();
            if (busca.equalsIgnoreCase("sair")){
                break;
            }
            if(nomes.contains(busca)){
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }
        scan.close();    
    }
}
