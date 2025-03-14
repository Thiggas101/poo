import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        if (input == null) return false;
        input = input.toLowerCase().replaceAll("\\s+", "");
        int left = 0;
        int right = input.length() - 1;
        
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        
        while (true) {
            System.out.print("Digite uma sequência: ");
            input = scanner.nextLine().trim();
            
            if (isValidInput(input)) {
                break;
            } else {
                System.out.println("Erro: A entrada não pode estar vazia.");
            }
        }
        
        if (isPalindrome(input)) {
            System.out.println("A sequência \"" + input + "\" é um palíndromo.");
        } else {
            System.out.println("A sequência \"" + input + "\" não é um palíndromo.");
        }
        
        scanner.close();
    }
}
