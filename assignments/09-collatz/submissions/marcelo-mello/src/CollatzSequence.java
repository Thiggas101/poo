import java.util.Scanner;

public class CollatzSequence {
    public static int calculateCollatzSum(int n) {
        int sum = 0;
        System.out.print("Sequência de Collatz: " + n);
        while (n != 1) {
            sum += n;
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (n * 3) + 1;
            }
            System.out.print(" → " + n);
        }
        sum += 1;
        System.out.println("\nSoma dos termos: " + sum);
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n > 0) {
                calculateCollatzSum(n);
            } else {
                System.out.println("Erro: O número deve ser um inteiro positivo.");
            }
        } else {
            System.out.println("Erro: Entrada inválida. Digite um número inteiro positivo.");
        }

        scanner.close();
    }
}
