import java.util.Scanner;

public class CollatzSequence {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = 0;
      do {
        System.out.println("Digite um número inteiro positivo: ");
        n = scanner.nextInt();
      } while (n <= 0);
      scanner.close();
      int ans = calculateCollatzSum(n);
      System.out.println("Soma dos termos: " + ans);
  }

  public static int nextCollatz(int n){
    if(n%2 == 0) return n/2;
    else return (n*3) + 1;
  }

  public static int calculateCollatzSum(int n){
    int sum = n;
    int prox = n;
    String ans = n + " -> ";
    while(prox != 1){
      prox = nextCollatz(prox);
      sum += prox;
      ans += prox;
      if(prox != 1) ans += " -> ";
    }
    System.out.println("Sequência de Collatz: " + ans);
    return sum;
  }
}
