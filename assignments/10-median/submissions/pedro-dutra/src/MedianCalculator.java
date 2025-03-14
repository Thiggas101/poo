import java.util.Scanner;

public class MedianCalculator {

    // Método para encontrar a mediana de três números
    public static int findMedian(int a, int b, int c) {
        // Verifica todas as possíveis combinações para encontrar a mediana
        if ((a >= b && a <= c) || (a >= c && a <= b)) {
            return a;
        } else if ((b >= a && b <= c) || (b >= c && b <= a)) {
            return b;
        } else {
            return c;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita os três números ao usuário
        System.out.print("Digite o primeiro número: ");
        int num1 = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = scanner.nextInt();

        System.out.print("Digite o terceiro número: ");
        int num3 = scanner.nextInt();

        // Calcula a mediana
        int median = findMedian(num1, num2, num3);

        // Exibe o resultado
        System.out.println("A mediana dos números é: " + median);

        scanner.close();
    }
}