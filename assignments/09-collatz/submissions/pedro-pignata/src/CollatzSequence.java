import java.util.Scanner;

public class CollatzSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            scanner.close();
            return;
        }

        int semente = scanner.nextInt();
        scanner.close();

        if (semente < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            return;
        }

        int soma = calculateCollatzSum(semente);
        System.out.println("Soma dos termos: " + soma);
    }

    public static int nextCollatz(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O número deve ser um inteiro positivo.");
        }
        return (n % 2 == 0) ? (n / 2) : ((n * 3) + 1);
    }

    public static int calculateCollatzSum(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O número deve ser um inteiro positivo.");
        }

        int soma = 0;
        System.out.print("Sequência de Collatz: ");
        while (n != 1) {
            System.out.print(n + " → ");
            soma += n;
            n = nextCollatz(n);
        }
        System.out.println(n);
        soma += n;
        return soma;
    }
}
