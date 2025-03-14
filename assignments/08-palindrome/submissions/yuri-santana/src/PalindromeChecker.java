import java.util.Scanner;

public class PalindromeChecker {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = new String();
    do {
      System.out.println("Digite uma sequência: ");
      input = scanner.nextLine();
    } while (!isValidInput(input));
    if (isPalindrome(input)) System.out.println("A sequência \"" + input + "\" é um palíndromo.");
    else System.out.println("A sequência \"" + input + "\" não é um palíndromo.");
  }

  public static boolean isValidInput(String input) {
    if(input.isEmpty()){
      System.out.println("Erro: A entrada não pode estar vazia.");
      return false;
    }
    else return true;
  }

  public static boolean isPalindrome(String input) {
    input = input.toLowerCase();
    input = input.replaceAll("\\s+","");
    int j = input.length()/2;
    int i = j-1;
    if(input.length()%2 != 0) j++;
    while(i >= 0){
      if(input.charAt(i) != input.charAt(j)) return false;
      i--;
      j++;
    }
    return true;
  }
}
