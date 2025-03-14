import java.util.Scanner;

class HealthProfile {
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    public HealthProfile(String firstName, String lastName, char gender, int dayOfBirth, int monthOfBirth, int yearOfBirth, double heightInInches, double weightInPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    public int calculateMaxHeartRate() {
        return 220 - calculateAge(2024);
    }

    public String calculateTargetHeartRate() {
        int maxRate = calculateMaxHeartRate();
        int minTarget = (int) (maxRate * 0.5);
        int maxTarget = (int) (maxRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    public void displayHealthProfile() {
        System.out.println("Nome: " + firstName + " " + lastName);
        System.out.println("Gênero: " + (gender == 'M' ? "Masculino" : "Feminino"));
        System.out.println("Data de nascimento: " + dayOfBirth + "/" + monthOfBirth + "/" + yearOfBirth);
        System.out.println("Idade: " + calculateAge(2024) + " anos");
        System.out.println("Altura: " + heightInInches + " polegadas");
        System.out.println("Peso: " + weightInPounds + " libras");
        System.out.printf("Índice de Massa Corporal (BMI): %.1f%n", calculateBMI());
        System.out.println("Frequência cardíaca máxima: " + calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + calculateTargetHeartRate());
        displayBMITable();
    }

    public static void displayBMITable() {
        System.out.println("\nTabela de Referência do BMI:");
        System.out.println("--------------------------------------");
        System.out.println("BMI         | Classificação");
        System.out.println("--------------------------------------");
        System.out.println("Menos de 18.5 | Abaixo do peso");
        System.out.println("18.5 – 24.9   | Peso normal");
        System.out.println("25.0 – 29.9   | Sobrepeso");
        System.out.println("30.0 ou mais  | Obesidade");
        System.out.println("--------------------------------------");
    }
}

public class HealthProfileTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = input.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia mês ano separados por espaço): ");
        int dayOfBirth = input.nextInt();
        int monthOfBirth = input.nextInt();
        int yearOfBirth = input.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double heightInInches = input.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weightInPounds = input.nextDouble();

        HealthProfile profile = new HealthProfile(firstName, lastName, gender, dayOfBirth, monthOfBirth, yearOfBirth, heightInInches, weightInPounds);
        System.out.println();
        profile.displayHealthProfile();
    }
}
