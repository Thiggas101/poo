import java.util.Scanner;

public class PalindromeChecker {

    // Método para verificar se a entrada é válida (não vazia ou apenas espaços)
    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    // Método para verificar se a entrada é um palíndromo
    public static boolean isPalindrome(String input) {
        input = input.toLowerCase(); // Ignorar maiúsculas e minúsculas
        int length = input.length();
        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - i - 1)) {
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
            input = scanner.nextLine().trim();
            
            if (!isValidInput(input)) {
                System.out.println("Erro: A entrada não pode estar vazia.");
            } else {
                break;
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
