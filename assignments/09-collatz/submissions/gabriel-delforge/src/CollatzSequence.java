import java.util.Scanner;

public class CollatzSequence {

    // Método para calcular o próximo número da sequência de Collatz
    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n * 3) + 1;
        }
    }

    // Método para calcular a soma dos termos da sequência de Collatz
    public static int calculateCollatzSum(int n) {
        int sum = 0;
        System.out.print("Sequência de Collatz: " + n);
        
        while (n != 1) {
            sum += n;
            n = nextCollatz(n);
            System.out.print(" → " + n);
        }
        
        sum += 1; // Adiciona o último termo (1)
        System.out.println();
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite um número inteiro positivo: ");
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n > 0) {
                int sum = calculateCollatzSum(n);
                System.out.println("Soma dos termos: " + sum);
            } else {
                System.out.println("Erro: O número deve ser um inteiro positivo.");
            }
        } else {
            System.out.println("Erro: Entrada inválida. Digite um número inteiro positivo.");
        }
        
        scanner.close();
    }
}
