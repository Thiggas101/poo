import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        if (input == null) return false;

        String normalized = input.toLowerCase().replaceAll("\\s+", "");
        int length = normalized.length();

        for (int i = 0; i < length / 2; i++) {
            if (normalized.charAt(i) != normalized.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void checkPalindrome(String input) {
        if (!isValidInput(input)) {
            System.out.println("Erro: A entrada não pode estar vazia.");
            return;
        }

        String message = isPalindrome(input) ? 
            "A sequência \"" + input + "\" é um palíndromo." : 
            "A sequência \"" + input + "\" não é um palíndromo.";

        System.out.println(message);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("Digite uma sequência: ");
            input = scanner.nextLine().trim();
            checkPalindrome(input);
        } while (!isValidInput(input));

        scanner.close();
    }
}