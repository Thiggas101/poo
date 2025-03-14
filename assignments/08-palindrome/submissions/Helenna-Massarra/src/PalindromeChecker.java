import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        if (!isValidInput(input)) {
            return false;
        }
        
        String cleanedInput = input.replaceAll("\\s+", "").toLowerCase();
        int length = cleanedInput.length();

        for (int i = 0; i < length / 2; i++) {
            if (cleanedInput.charAt(i) != cleanedInput.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Digite uma sequência: ");
            input = scanner.nextLine();

            if (!isValidInput(input)) {
                System.out.println("Erro: A entrada não pode estar vazia.");
                continue;
            }

            if (isPalindrome(input)) {
                System.out.printf("A sequência \"%s\" é um palíndromo.%n", input);
            } else {
                System.out.printf("A sequência \"%s\" não é um palíndromo.%n", input);
            }
            break;
        }

        scanner.close();
    }
}
