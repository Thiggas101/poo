import java.util.Scanner;

public class PalindromeChecker {

    // Método para verificar se a entrada é válida
    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    // Método para verificar se a entrada é um palíndromo
    public static boolean isPalindrome(String input) {
        // Converte a entrada para minúsculas para ignorar diferenças entre maiúsculas e minúsculas
        input = input.toLowerCase();
        int length = input.length();

        // Compara os caracteres da string de frente para trás e de trás para frente
        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - 1 - i)) {
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

            // Verifica se a entrada é válida
            if (!isValidInput(input)) {
                System.out.println("Erro: A entrada não pode estar vazia.");
                continue; // Solicita a entrada novamente
            }

            // Verifica se a entrada é um palíndromo
            if (isPalindrome(input)) {
                System.out.println("A sequência \"" + input + "\" é um palíndromo.");
            } else {
                System.out.println("A sequência \"" + input + "\" não é um palíndromo.");
            }

            break; // Sai do loop após uma entrada válida
        }

        scanner.close();
    }
}