import java.util.Scanner;

public class FortalecerSenha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senha = scanner.next();

        String senhaFortalecida = fortalecerSenha(senha);
        int tempoDigitacao = calcularTempoDigitacao(senhaFortalecida);

        System.out.println("Senha fortalecida: " + senhaFortalecida);
        System.out.println("Tempo de digitação: " + tempoDigitacao + " segundos");

        scanner.close();
    }

    public static String fortalecerSenha(String senha) {
        return "a" + senha;
    }

    public static int calcularTempoDigitacao(String senha) {
        int tempo = 2; // O primeiro caractere leva 2 segundos

        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                tempo += 1;
            } else {
                tempo += 2;
            }
        }

        return tempo;
    }
}
