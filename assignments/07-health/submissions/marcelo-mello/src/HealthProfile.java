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

    public HealthProfile(String firstName, String lastName, char gender, int dayOfBirth, int monthOfBirth,
            int yearOfBirth, double heightInInches, double weightInPounds) {
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

    public int calculateMaxHeartRate(int currentYear) {
        return 220 - calculateAge(currentYear);
    }

    public String calculateTargetHeartRate(int currentYear) {
        int maxHeartRate = calculateMaxHeartRate(currentYear);
        int minTarget = (int) (maxHeartRate * 0.50);
        int maxTarget = (int) (maxHeartRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    public static void displayBMITable() {
        System.out.println("\nTabela de Referência do BMI:");
        System.out.println("Menos de 18.5: Abaixo do peso");
        System.out.println("18.5 – 24.9: Peso normal");
        System.out.println("25.0 – 29.9: Sobrepeso");
        System.out.println("30.0 ou mais: Obesidade");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.next();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = scanner.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia mês ano): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = scanner.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = scanner.nextDouble();

        HealthProfile profile = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);
        int currentYear = java.time.Year.now().getValue();

        System.out.println("\nNome: " + profile.firstName + " " + profile.lastName);
        System.out.println("Gênero: " + (profile.gender == 'M' ? "Masculino" : "Feminino"));
        System.out.println(
                "Data de nascimento: " + profile.dayOfBirth + "/" + profile.monthOfBirth + "/" + profile.yearOfBirth);
        System.out.println("Idade: " + profile.calculateAge(currentYear) + " anos");
        System.out.println("Altura: " + profile.heightInInches + " polegadas");
        System.out.println("Peso: " + profile.weightInPounds + " libras");
        System.out.printf("Índice de Massa Corporal (BMI): %.1f\n", profile.calculateBMI());
        System.out.println("Frequência cardíaca máxima: " + profile.calculateMaxHeartRate(currentYear) + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + profile.calculateTargetHeartRate(currentYear));

        displayBMITable();
        scanner.close();
    }
}
