import java.util.Scanner;

public class CollatzSequence {

    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n * 3) + 1;
        }
    }

    public static int calculateCollatzSum(int n) {
        int sum = 0;
        System.out.print("Sequência de Collatz: " + n);
        while (n != 1) {
            sum += n;
            n = nextCollatz(n);
            System.out.print(" → " + n);
        }
        sum += 1; 
        System.out.println();
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.print("Digite um número inteiro positivo: ");
        while (true) {
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) {
                    break;
                } else {
                    System.out.print("Erro: O número deve ser um inteiro positivo. Tente novamente: ");
                }
            } else {
                System.out.print("Erro: Entrada inválida. Tente novamente: ");
                scanner.next(); 
            }
        }

        int soma = calculateCollatzSum(n);
        System.out.println("Soma dos termos: " + soma);

        scanner.close();
    }
}
