import java.util.Scanner;

public class MedianCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicita os três números inteiros ao usuário
        System.out.print("Digite o primeiro número: ");
        int num1 = sc.nextInt();
        System.out.print("Digite o segundo número: ");
        int num2 = sc.nextInt();
        System.out.print("Digite o terceiro número: ");
        int num3 = sc.nextInt();

        // Chama o método para calcular a mediana
        int mediana = findMedian(num1, num2, num3);

        // Exibe a mediana
        System.out.println("A mediana dos números é: " + mediana);

        sc.close();
    }

    // Método para calcular a mediana de três números inteiros
    public static int findMedian(int a, int b, int c) {
        if ((a >= b && a <= c) || (a <= b && a >= c)) {
            return a;
        } else if ((b >= a && b <= c) || (b <= a && b >= c)) {
            return b;
        } else {
            return c;
        }
    }
}
