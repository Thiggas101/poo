import java.util.Scanner;

public class HealthProfile {
    private final String firstName;
    private final String lastName;
    private final char gender;
    private final int dayOfBirth;
    private final int monthOfBirth;
    private final int yearOfBirth;
    private final double heightInInches;
    private final double weightInPounds;

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

    public int calculateAge() {
        int currentYear = 2025;
        int age = currentYear - yearOfBirth;

        if (monthOfBirth > 3 || (monthOfBirth == 3 && dayOfBirth > 5)) {
            age--;
        }

        return age;
    }

    public int calculateMaxHeartRate() {
        return 220 - calculateAge();
    }

    public String calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();
        int minTarget = (int) Math.round(maxHeartRate * 0.50);
        int maxTarget = (int) Math.round(maxHeartRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    public static void displayBMITable() {
        System.out.println("\nTabela de Classificação do BMI:");
        System.out.println("BMI\t\tClassificação");
        System.out.println("Menos de 18.5\tAbaixo do peso");
        System.out.println("18.5 – 24.9\tPeso normal");
        System.out.println("25.0 – 29.9\tSobrepeso");
        System.out.println("30.0 ou mais\tObesidade");
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
        double heightInInches = scanner.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weightInPounds = scanner.nextDouble();

        HealthProfile person = new HealthProfile(firstName, lastName, gender, day, month, year, heightInInches, weightInPounds);

        System.out.println("\nNome: " + person.firstName + " " + person.lastName);
        System.out.println("Gênero: " + (person.gender == 'M' ? "Masculino" : "Feminino"));
        System.out.println("Data de nascimento: " + person.dayOfBirth + "/" + person.monthOfBirth + "/" + person.yearOfBirth);
        System.out.println("Idade: " + person.calculateAge() + " anos");
        System.out.println("Altura: " + person.heightInInches + " polegadas");
        System.out.println("Peso: " + person.weightInPounds + " libras");
        System.out.printf("Índice de Massa Corporal (BMI): %.1f\n", person.calculateBMI());
        System.out.println("Frequência cardíaca máxima: " + person.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + person.calculateTargetHeartRate());

        displayBMITable();

        scanner.close();
    }
}