import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
         System.out.println("Digite seu Primeiro nome: ");
         String primeiroNome = scanner.nextLine();

         System.out.println("Digite seu sobrenome: ");
         String sobrenome = scanner.nextLine();

         System.out.println("Digite o seu gênero: ");
         char genero = scanner.next().charAt(0);

         System.out.println("Digite a data do seu nascimento: ");
         int dia = scanner.nextInt(), mes = scanner.nextInt(), ano = scanner.nextInt();

         System.out.println("Digite sua altura em polegadas: ");
         double altura = scanner.nextDouble();

         System.out.println("Digite seu peso em libras: ");
         double peso = scanner.nextDouble();

         System.out.println("Altura: "+altura);
         System.out.println("Peso: "+peso);
         
         System.out.println("Nome: " +primeiroNome+ " " + sobrenome);
         System.out.println("Data de nascimento: " +dia+ "/" +mes+ "/" +ano);

         HealthProfile healthprofile = new HealthProfile(dayOfBirth, monthOfBirth, yearOfBirth, gender, firstName, LastName, weightInPounds, heightInInches);

         int idade = healthprofile.calculateAge(dia, mes, ano);
         System.out.println("Idade: " +idade);

         int frequenciaMaxima = healthprofile.calcularfrequenciaMaxima(idade);
         System.out.println("Frequência cardíaca máxima: "+frequenciaMaxima+ "bpm");

         String frequenciaIdeal = healthprofile.frequenciaCardiacaIdeal(frequenciaMaxima);
         System.out.println(frequenciaIdeal);

         double bmi = healthprofile.calcularBMI(peso, altura);
         System.out.println("BMI: " +bmi);

         System.out.println("| **BMI**           | **Classificação**      |");
         System.out.println("|-------------------|------------------------|");
         System.out.println("| **Menos de 18.5** | Abaixo do peso         |");
         System.out.println("| **18.5 – 24.9**   | Peso normal            |");
         System.out.println("| **25.0 – 29.9**   | Sobrepeso              |");
         System.out.println("| **30.0 ou mais**  | Obesidade              |");

}
}
