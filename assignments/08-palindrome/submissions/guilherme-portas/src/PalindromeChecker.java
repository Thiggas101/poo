import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        do {
            System.out.print("Digite uma sequência: ");
            input = scanner.nextLine();
        } while(!isValidInput(input));
        
        if(isPalindrome(input)) System.out.println("A sequência \"" + input + "\" é um palíndromo.");
        else System.out.println("A sequência \"" + input + "\" não é um palíndromo.");
        scanner.close();
    }

    public static boolean isValidInput(String input) {
        if(input.strip().equals("")) {
            System.out.println("Erro: A entrada não pode estar vazia."); 
            return false;
        }
        else return true;
    }

    public static boolean isPalindrome(String input) {
        input = input.toLowerCase();
        int pos_inicial = 0, pos_final = input.length() -1;
        while (pos_inicial != pos_final && pos_inicial != pos_final +1) {
            if(input.charAt(pos_inicial) != input.charAt(pos_final)) return false;
            pos_inicial++; pos_final--;
        }
        return true;
    }
}