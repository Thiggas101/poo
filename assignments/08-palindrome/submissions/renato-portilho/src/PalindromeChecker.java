import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma sequencia: ");
        String sequencia = scanner.next();

        if (palindromo(sequencia)) {
            System.out.println("A sequência é um palíndromo!");
        } else
            System.out.println("A sequência não é um palíndromo.");

    }

    public static boolean palindromoValido(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        } else

            return true;
    }

    public static boolean palindromo(String input) {
        String sanitizedInput = new String();
        int length = 0;
        if (!palindromoValido(input)) {
            return false;
        } else {
            sanitizedInput = input.toLowerCase();
            length = sanitizedInput.length();
        }
        // Verifica se é um palíndromo usando `charAt` e `length`.
        for (int i = 0; i < length / 2; i++) {
            if (sanitizedInput.charAt(i) != sanitizedInput.charAt(length - 1 - i)) {
                return false; // Se algum caractere não casar, não é um palíndromo.

            }

        }
        return true;
    }
}
