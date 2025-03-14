import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class HealthProfile {
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    public HealthProfile(String firstName, String lastName, char gender, int day, int month, int year, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = day;
        this.monthOfBirth = month;
        this.yearOfBirth = year;
        this.heightInInches = height;
        this.weightInPounds = weight;
    }

    public int calculateAge() {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }

    public int calculateMaxHeartRate() {
        return 220 - calculateAge();
    }

    public String calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();
        double minTarget = maxHeartRate * 0.5;
        double maxTarget = maxHeartRate * 0.85;
        return String.format("%.0f bpm - %.0f bpm", minTarget, maxTarget);
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    public void displayBMIClassification() {
        System.out.println("\nBMI\tClassificação");
        System.out.println("Menos de 18.5\tAbaixo do peso");
        System.out.println("18.5 – 24.9\tPeso normal");
        System.out.println("25.0 – 29.9\tSobrepeso");
        System.out.println("30.0 ou mais\tObesidade");
    }

    public void displayProfile() {
        System.out.printf("\nNome: %s %s\n", firstName, lastName);
        System.out.printf("Gênero: %s\n", (gender == 'M' || gender == 'm') ? "Masculino" : "Feminino");
        System.out.printf("Data de nascimento: %d/%d/%d\n", dayOfBirth, monthOfBirth, yearOfBirth);
        System.out.printf("Idade: %d anos\n", calculateAge());
        System.out.printf("Altura: %.2f polegadas\n", heightInInches);
        System.out.printf("Peso: %.2f libras\n", weightInPounds);
        System.out.printf("Índice de Massa Corporal (BMI): %.1f\n", calculateBMI());
        System.out.printf("Frequência cardíaca máxima: %d bpm\n", calculateMaxHeartRate());
        System.out.printf("Faixa de frequência cardíaca alvo: %s\n", calculateTargetHeartRate());
        displayBMIClassification();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.next();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = input.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia mês ano): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = input.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = input.nextDouble();

        HealthProfile profile = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);
        profile.displayProfile();
    }
} 
