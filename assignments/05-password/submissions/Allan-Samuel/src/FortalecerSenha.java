/* Nome: Allan Samuel Alves do Monte
   Matrícula: 24101279     */

import java.util.Scanner;

public class FortalecerSenha {

    public static int calcularTempoDigitacao(String s) {
        int tempo = 2; 
        for (int i = 1; i < s.length(); i++) {
            tempo += (s.charAt(i) == s.charAt(i - 1)) ? 1 : 2;
        }
        return tempo;
    }

    public static String fortalecerSenha(String s) {
        int maxTempo = 0;
        String melhorSenha = s;

        for (char letra = 'a'; letra <= 'z'; letra++) {
            for (int i = 0; i <= s.length(); i++) {
                String novaSenha = new StringBuilder(s).insert(i, letra).toString(); // Cria novas strings sem precisar criar uma nova.
                int tempo = calcularTempoDigitacao(novaSenha);
                if (tempo > maxTempo) {
                    maxTempo = tempo;
                    melhorSenha = novaSenha;
                }
            }
        }

        return melhorSenha;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();

        if (senha.length() < 1 || senha.length() > 10) {
            System.out.println("A senha deve ter entre 1 e 10 caracteres.");
            return;
        }

        String senhaFortalecida = fortalecerSenha(senha);

        System.out.println("Senha fortalecida: " + senhaFortalecida);

        scanner.close();
    }
}
