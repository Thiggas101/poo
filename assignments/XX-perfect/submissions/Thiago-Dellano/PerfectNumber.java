import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerfectNumber {

    // Retorna true se o número for perfeito
    public static boolean isPerfect(int number) {
        List<Integer> factors = getFactors(number);
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum == number;
    }

    // Retorna os fatores próprios do número (excluindo ele mesmo)
    public static List<Integer> getFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                factors.add(i);
                int complement = number / i;
                if (complement != i && complement != number) {
                    factors.add(complement);
                }
            }
        }
        factors.remove(Integer.valueOf(number)); // garante que o número em si não esteja na lista
        factors.sort(Integer::compareTo); // ordena os fatores
        return factors;
    }

    // Método principal
    public static void main(String[] args) {
        System.out.println("Números perfeitos entre 1 e 1000:");

        for (int i = 1; i <= 1000; i++) {
            if (isPerfect(i)) {
                List<Integer> factors = getFactors(i);
                System.out.println(i + " é um número perfeito. Fatores: " + formatFactors(factors));
            }
        }

        System.out.println("\nTeste adicional:");
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        while (true) {
            System.out.print("Digite um número para verificar se é perfeito: ");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input > 0) break;
                else System.out.println("Por favor, digite um número inteiro positivo.");
            } else {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.next(); // consome entrada inválida
            }
        }

        if (isPerfect(input)) {
            List<Integer> factors = getFactors(input);
            System.out.println(input + " é um número perfeito. Fatores: " + formatFactors(factors));
        } else {
            System.out.println(input + " não é um número perfeito.");
        }

        scanner.close();
    }

    // Formata a lista de fatores como string separada por vírgulas
    private static String formatFactors(List<Integer> factors) {
        return String.join(", ", factors.stream().map(String::valueOf).toArray(String[]::new));
    }
}
