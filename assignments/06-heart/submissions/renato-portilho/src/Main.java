import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       

        Scanner scanner = new Scanner(System.in);
         System.out.println("Digite seu Primeiro nome: ");
         String firstName = scanner.nextLine();

         System.out.println("Digite seu nome: ");
         String lastName = scanner.nextLine();

         
         System.out.println("Digite a data do seu nascimento: ");
         int dayOfBIrth = scanner.nextInt(), monthOfBirth = scanner.nextInt(), yearOfBirth = scanner.nextInt();
         
         System.out.println("Nome: " +firstName+ " " + lastName);
         System.out.println("Data de nascimento: " +dayOfBIrth+ "/" +monthOfBirth+ "/" +yearOfBirth);

         HeartRates heartrates = new HeartRates(firstName, lastName, yearOfBirth, monthOfBirth, dayOfBIrth);

         int idade = heartrates.calcularIdade(dayOfBIrth, monthOfBirth, yearOfBirth);
         System.out.println("Idade: " +idade);

         int frequenciaMaxima = heartrates.calcularfrequenciaMaxima(idade);
         System.out.println("Frequência cardíaca máxima: "+frequenciaMaxima+ " bpm");

         String frequenciaIdeal = heartrates.frequenciaCardiacaIdeal(frequenciaMaxima);
         System.out.println(frequenciaIdeal);

         

         

 }

}
