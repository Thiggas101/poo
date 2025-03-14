import java.util.Scanner;

public class MedianCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int a = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        int b = scanner.nextInt();

        System.out.print("Digite o terceiro número: ");
        int c = scanner.nextInt();
        
        System.out.println("A mediana dos números é: " + findMedian(a, b, c));
        scanner.close();
    }

    public static int findMedian(int a, int b, int c) {
        if(c >= a) {
            if(c >= b) {
                if(a >= b) return a;
                else return b;
            }
            else return c;
        }
        else {
            if(b > c) {
                if(b > a) return a;
                else return b;
            }
            else return c;
        }
    }
}