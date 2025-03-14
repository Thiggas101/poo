import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        input = input.replaceAll("\\s", "").toLowerCase(); // Remove espaços e converte para minúsculas
        int left = 0, right = input.length() - 1;
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

        System.out.print("Digite uma sequência: ");
        String input = scanner.nextLine();

        if (!isValidInput(input)) {
            System.out.println("Erro: A entrada não pode estar vazia.");
        } else {
            if (isPalindrome(input)) {
                System.out.println("A sequência \"" + input + "\" é um palíndromo.");
            } else {
                System.out.println("A sequência \"" + input + "\" não é um palíndromo.");
            }
        }

        scanner.close();
    }
}
