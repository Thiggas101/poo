import java.util.Scanner;

public class CollatzSequence {

    // Método para calcular o próximo número na sequência de Collatz
    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2; // Se n for par, divide por 2
        } else {
            return (n * 3) + 1; // Se n for ímpar, multiplica por 3 e soma 1
        }
    }

    // Método para calcular a soma dos termos da sequência de Collatz
    public static int calculateCollatzSum(int n) {
        int sum = n; // Inicia a soma com o valor inicial
        while (n != 1) {
            n = nextCollatz(n); // Calcula o próximo termo
            sum += n; // Adiciona o termo à soma
        }
        return sum;
    }

    // Método para gerar e exibir a sequência de Collatz
    public static void generateCollatzSequence(int n) {
        System.out.print("Sequência de Collatz: " + n);
        while (n != 1) {
            n = nextCollatz(n);
            System.out.print(" ↔ " + n);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        int n = scanner.nextInt();

        // Validação da entrada
        if (n < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
        } else {
            // Exibe a sequência de Collatz
            generateCollatzSequence(n);

            // Calcula e exibe a soma dos termos
            int sum = calculateCollatzSum(n);
            System.out.println("Soma dos termos: " + sum);
        }

        scanner.close();
    }
}