import java.util.Scanner;

public class CollatzSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite um número inteiro positivo: ");
        
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            
            if (n < 1) {
                System.out.println("Erro: O número deve ser um inteiro positivo.");
            } else {
                imprimirSequenciaCollatz(n);
                int soma = calculateCollatzSum(n);
                System.out.println("\nSoma dos termos: " + soma);
            }
        } else {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
        }
        
        scanner.close();
    }
    
    // Método público e estático para calcular o próximo número da sequência de Collatz
    public static int nextCollatz(int n) {
        return (n % 2 == 0) ? n / 2 : (n * 3) + 1;
    }

    // Método para calcular a soma da sequência de Collatz
    public static int calculateCollatzSum(int n) {
        int soma = 0;
        while (n != 1) {
            soma += n;
            n = nextCollatz(n);
        }
        return soma + 1; // Adiciona o último termo (1) à soma
    }

    // Método para imprimir a sequência de Collatz
    public static void imprimirSequenciaCollatz(int n) {
        System.out.print("Sequência de Collatz: " + n);
        while (n != 1) {
            n = nextCollatz(n);
            System.out.print(" → " + n);
        }
    }
}
