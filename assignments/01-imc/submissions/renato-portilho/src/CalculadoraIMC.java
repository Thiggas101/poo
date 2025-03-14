import java.util.Scanner;


public class CalculadoraIMC {
    

    public static double calcularIMC(double peso, double altura){
    return peso/ (altura * altura);
    }
    
    public static String classificarIMC(double imc){
        if(imc < 18.50){
                return "Abaixo do peso";
}else{
        if(imc >= 18.50 && imc < 24.99){
                return "Eutrófico";
}else{
        if (imc >= 24.99 && imc < 29.99) {
                return "Sobrepeso";               
}else{
        if (imc >= 29.99 && imc < 34.99) {
                return "Obesidade grau I";
}else{
        if (imc >= 34.99 && imc < 39.99) {
                return "Obesidade grau II";
}else{
                return "Obesidade grau III";
                
                }
            }
        }
    }
}

}

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite sua altura:");
        double altura = sc.nextDouble();

        System.out.println("Digite seu peso:");
        double peso = sc.nextDouble();

        double imc = calcularIMC(altura, peso);

        System.out.println("Seu imc é: " + imc);
        System.out.println("Sua classificação é: " + classificarIMC(imc));
    }

            
}

    



