import java.util.Scanner;

public class MedianCalculator {
    // Método para encontrar a mediana de três números inteiros
    public static int findMedian(int a, int b, int c) {
        if ((a >= b && a <= c) || (a <= b && a >= c)) {
            return a;
        } else if ((b >= a && b <= c) || (b <= a && b >= c)) {
            return b;
        } else {
            return c;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar entrada do usuário
        System.out.print("Digite o primeiro número: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Digite o segundo número: ");
        int num2 = scanner.nextInt();
        
        System.out.print("Digite o terceiro número: ");
        int num3 = scanner.nextInt();
        
        // Calcular e exibir a mediana
        int median = findMedian(num1, num2, num3);
        System.out.println("A mediana dos números é: " + median);
        
        scanner.close();
    }
}
