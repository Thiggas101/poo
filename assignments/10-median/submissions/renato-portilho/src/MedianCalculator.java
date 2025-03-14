import java.util.Scanner;

public class MedianCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro número inteiro: ");
        int a = scanner.nextInt();

        System.out.println("Digite o segundo número inteiro: ");
        int b = scanner.nextInt();

        System.out.println("Digite o terceiro número inteiro: ");
        int c = scanner.nextInt();

        int mediana = findMedian(a, b, c);
        System.out.println("A mediana é: "+mediana);

    }

    public static int findMedian(int a, int b, int c){
        if((a < b && a > c) || (a>b && a<c)){
            return a;
        }else if ((b>a && b<c) || (b<a && b>c)) {
            return b;
        }else if ((c>a && c<b) || (c<a && c>b)) {
            return c;
        }else if (a == b || a ==c) {
            return a;
        }else if (b == a || b == c) {
            return b;
        }else 

        return -1;

    }
    
}
