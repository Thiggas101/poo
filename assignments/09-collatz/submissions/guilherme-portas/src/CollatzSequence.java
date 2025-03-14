import java.util.Scanner;

public class CollatzSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro positivo: ");
        int num = scanner.nextInt();
        
        if(num < 0) {
            scanner.close();
            throw new java.lang.Error("O número deve ser um inteiro positivo.");
        }

        int num_collatz = num;
        System.out.print("Sequência de Collatz: " + num + " -> ");
        if (num_collatz != 1 && num_collatz != 0) {
            while(num_collatz != 1) {
                num_collatz = nextCollatz(num_collatz);
                System.out.print(num_collatz + " -> ");
            }
        }
        System.out.print("\nSoma dos termos: " + calculateCollatzSum(num));
        scanner.close();
    }

    public static int nextCollatz(int num) {
        if (num % 2 == 0) {
            return num / 2; 
        }
        else return (num * 3) + 1;
    }

    public static int calculateCollatzSum(int num) {
        int sum = num;
        if(num == 1 || num == 0) return num;
        while(num != 1) {
            num = nextCollatz(num);
            sum += num;
        }
        return sum;
    }
}