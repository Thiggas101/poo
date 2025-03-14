import java.util.Scanner;

public class FortalecerSenha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String senha;

        do {
            System.out.print("Digite a senha: ");
            senha = scanner.nextLine();
        } while (senha.length() < 1 || senha.length() > 10 || !senha.matches("[a-z]+"));

        scanner.close();

        String senhaNova = fortalecerSenha(senha);
        int tempo = calcularTempoDigitacao(senhaNova);

        System.out.println("Senha fortalecida: " + senhaNova);
        System.out.println("Tempo de digitação: " + tempo + " segundos");
    }

    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int maiorTempo = 0;

        for (int i = 0; i <= s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String novaSenha = s.substring(0, i) + c + s.substring(i);
                int tempo = calcularTempoDigitacao(novaSenha);

                if (tempo > maiorTempo) {
                    maiorTempo = tempo;
                    melhorSenha = novaSenha;
                }
            }
        }

        return melhorSenha;
    }

    public static int calcularTempoDigitacao(String s) {
        int tempo = 2; 

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                tempo += 1; 
            } else {
                tempo += 2; 
            }
        }

        return tempo;
    }
}
