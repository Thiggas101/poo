import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NomeManager gerente = new NomeManager();

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        while (true) {
            System.out.print("> ");
            String entrada = scanner.nextLine().trim();
            if (entrada.equalsIgnoreCase("fim")) break;

            gerente.adicionarNome(entrada);
        }

        System.out.println("\nNomes cadastrados:");
        gerente.exibirNomes();

        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");
        while (true) {
            System.out.print("> ");
            String pesquisa = scanner.nextLine().trim();
            if (pesquisa.equalsIgnoreCase("sair")) break;

            if (gerente.nomeExiste(pesquisa)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        scanner.close();
    }
}
