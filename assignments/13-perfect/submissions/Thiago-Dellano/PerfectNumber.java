import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerfectNumber {

    // Método para verificar se um número é perfeito
    public static boolean isPerfect(int number) {
        int sum = 0;
        List<Integer> factors = getFactors(number);
        
        for (int factor : factors) {
            sum += factor;
        }
        
        return sum == number;
    }

    // Método para obter os divisores próprios de um número
    public static List<Integer> getFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }
        
        return factors;
    }

    public static void main(String[] args) {
        System.out.println("Números perfeitos entre 1 e 1000:");
        
        for (int i = 1; i <= 1000; i++) {
            if (isPerfect(i)) {
                System.out.println(i + " é um número perfeito. Fatores: " + getFactors(i));
            }
        }
        
        // Teste adicional com entrada do usuário
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite um número para verificar se é perfeito: ");
        int userNumber = scanner.nextInt();
        
        if (isPerfect(userNumber)) {
            System.out.println(userNumber + " é um número perfeito. Fatores: " + getFactors(userNumber));
        } else {
            System.out.println(userNumber + " não é um número perfeito.");
        }
        
        scanner.close();
    }
}