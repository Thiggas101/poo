import java.util.Scanner;

public class FortalecerSenha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String senhaUsuario;

        do {
            System.out.println("Digite a senha (entre 1 e 10 caracteres, somente letras minúsculas): ");
            senhaUsuario = scanner.nextLine();
        } while (senhaUsuario.length() < 1 || senhaUsuario.length() >= 11 || !senhaUsuario.matches("[a-z]+"));

        String senhaFortalecida = fortalecerSenha(senhaUsuario);
        int tempo = calcularTempoDigitacao(senhaFortalecida);

        System.out.println("Senha fortalecida: " + senhaFortalecida);
        

        scanner.close();
    }

    public static String fortalecerSenha(String senha) {
        boolean letraDupla = true;
        String novaSenha = "";

        for (int i = 0; i < senha.length() - 1; i++) {
            novaSenha += senha.charAt(i);
            if (senha.charAt(i) == senha.charAt(i + 1) && letraDupla) {
                letraDupla = false;
                if (senha.charAt(i) == 'a') novaSenha += 'b';
                else novaSenha += 'a';
            }
        }

        novaSenha += senha.charAt(senha.length() - 1);

        if (letraDupla) {
            if (senha.charAt(senha.length() - 1) == 'a') novaSenha += 'b';
            else novaSenha += 'a';
        }

        return novaSenha;
    }

    public static int calcularTempoDigitacao(String senha) {
        int tempo = 2; 
        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) tempo += 1; 
            else tempo += 2; 
            System.out.println("Tempo de digitação: " + tempo);
        }
        return tempo;
    }
}
