import java.util.Scanner;

public class MedianCalculator {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Digite o primeiro número: ");
      int a = scanner.nextInt();
      System.out.println("Digite o segundo número: ");
      int b = scanner.nextInt();
      System.out.println("Digite o terceiro número: ");
      int c = scanner.nextInt();
      int ans = findMedian(a, b, c);
      System.out.println("A mediana dos números é: " + ans);
  }

  public static int findMedian(int a, int b, int c){
    if(a >= b){
      if(a >= c){
        if (b >= c) return b;
        else return c;
      }
      else return a;
    }
    else{
      if(a >= c) return a;
      else return c;
    }
  }
}
