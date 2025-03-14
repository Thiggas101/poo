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

        System.out.print("Digite um número inteiro positivo: ");
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (num > 0) {
                int sum = calculateCollatzSum(num);
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
