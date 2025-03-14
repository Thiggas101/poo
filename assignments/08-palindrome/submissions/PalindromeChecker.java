
    import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Digite uma sequência: ");
            input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Erro: A entrada não pode estar vazia.");
            } else {
                String formattedInput = input.toLowerCase().replaceAll("[^a-z0-9]", "");
                if (formattedInput.equals(new StringBuilder(formattedInput).reverse().toString())) {
                    System.out.println("A sequência \"" + input + "\" é um palíndromo.");
                } else {
                    System.out.println("A sequência \"" + input + "\" não é um palíndromo.");
                }
                break;
            }
        }

        scanner.close();
    }
}
