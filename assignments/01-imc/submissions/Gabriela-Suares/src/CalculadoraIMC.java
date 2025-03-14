import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu peso (kg): ");
        double peso = scanner.nextDouble();
        System.out.print("Digite sua altura (m): ");
        double altura = scanner.nextDouble();
        scanner.close();

        double imc = peso / (altura * altura);
        String classificacao = (imc < 18.5) ? "Abaixo do peso" :
            (imc < 25) ? "Eutrófico" :
            (imc < 30) ? "Sobrepeso" :
            (imc < 35) ? "Obesidade grau I" :
            (imc < 40) ? "Obesidade grau II" : "Obesidade grau III";

        System.out.printf("Seu IMC é: %.2f\nClassificação: %s\n", imc, classificacao);
    }
}
