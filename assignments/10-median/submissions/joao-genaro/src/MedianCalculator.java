import java.util.Scanner;

public class MedianCalculator {

    public static int findMedian(int a, int b, int c) {
        return (a >= b && a <= c) || (a >= c && a <= b) ? a :
               (b >= a && b <= c) || (b >= c && b <= a) ? b : c;
    }

    public static void displayResult(int median) {
        System.out.println("A mediana dos números é: " + median);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int num1 = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = scanner.nextInt();

        System.out.print("Digite o terceiro número: ");
        int num3 = scanner.nextInt();

        int median = findMedian(num1, num2, num3);
        displayResult(median);

        scanner.close();
    }
}