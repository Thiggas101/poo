//Nome: Allan Samuel Alves do Monte
//Matrícula: 24101279

import java.util.Scanner;
import java.time.LocalDate;

public class HeartRates {
    private String firstName;
    private String lastName;
    private int dayOfBirth, monthOfBirth, yearOfBirth;

    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    // calculando a idade considerando o mês e o dia (para passar nos testes)
    public int calculateAge(int currentYear, int currentMonth, int currentDay) {
        int age = currentYear - this.yearOfBirth;

        if (this.monthOfBirth > currentMonth || (this.monthOfBirth == currentMonth && this.dayOfBirth > currentDay)) {
            age--; 
        }
        
        return age;
    }

    public int calculateMaxHeartRate(int currentYear, int currentMonth, int currentDay) {
        int age = calculateAge(currentYear, currentMonth, currentDay);
        return 220 - age;
    }

    public String calculateTargetHeartRate(int currentYear, int currentMonth, int currentDay) {
        int maxHeartRate = calculateMaxHeartRate(currentYear, currentMonth, currentDay);
        double minTarget = maxHeartRate * 0.50;
        double maxTarget = maxHeartRate * 0.85;
        
        // Arredonda os valores para o número inteiro mais próximo (tentar corrigir o erro)
        return String.format("%.0f bpm - %.0f bpm", minTarget, (double) Math.round(maxTarget));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.next();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        HeartRates person = new HeartRates(firstName, lastName, day, month, year);

        int currentYear = LocalDate.now().getYear();
        int currentMonth = LocalDate.now().getMonthValue();
        int currentDay = LocalDate.now().getDayOfMonth();

        int age = person.calculateAge(currentYear, currentMonth, currentDay);
        int maxHeartRate = person.calculateMaxHeartRate(currentYear, currentMonth, currentDay);
        String targetHeartRate = person.calculateTargetHeartRate(currentYear, currentMonth, currentDay);
        System.out.println("\nMonitoramento da Frequência Cardíaca:\n");
        System.out.println("Nome: " + person.getFirstName() + " " + person.getLastName());
        System.out.printf("Data de nascimento: %02d/%02d/%d%n", person.getDayOfBirth(), person.getMonthOfBirth(), person.getYearOfBirth());
        System.out.println("Idade: " + age + " anos");
        System.out.println("Frequência cardíaca máxima: " + maxHeartRate + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + targetHeartRate);

        scanner.close();
    }
}
