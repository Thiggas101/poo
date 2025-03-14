/* Nome: Allan Samuel Alves do Monte
   Matrícula: 24101279     */
   
import java.util.Scanner;

public class CalculadoraIMC {

    public static double calcularIMC(double peso, double altura){
        
        double resultado;
        
        resultado = peso/(altura*altura);
        
        return resultado;
    }
    
    public static String classificarIMC(double valorIMC){
        
        if (valorIMC < 18.50){
            return "Abaixo do peso";
        }
        else if (valorIMC >= 18.5 && valorIMC < 24.99){
            return "Eutrófico";
        }
        else if (valorIMC >= 25.0 && valorIMC < 29.99){
             return "Sobrepeso";
        }
        else if (valorIMC >= 30.0 && valorIMC < 34.99){
            return "Obesidade grau I";
        }
        else if (valorIMC >= 35.0 && valorIMC < 39.99){
            return "Obesidade grau II";
        }
        else if (valorIMC >= 40.0){
            return "Obesidade grau III";
        }
        
        return "Classificação Inválida";
    }
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite seu peso em quilogramas: ");
		double peso_usuario = scanner.nextDouble();
		
		System.out.println("Digite sua altura em metros: ");
		double altura_usuario = scanner.nextDouble();
		
		double imc = calcularIMC(peso_usuario, altura_usuario);
		
		System.out.println("Seu IMC é: " + imc);
		String classificacao = classificarIMC(imc);
		System.out.println("Classificação: " + classificacao);
		
	}
}
