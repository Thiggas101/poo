import java.util.Calendar;
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public int calculateAge(int currentYear) {
        int age = currentYear - yearOfBirth;
        Calendar today = Calendar.getInstance();
        int currentMonth = today.get(Calendar.MONTH) + 1;
        int currentDay = today.get(Calendar.DAY_OF_MONTH);
        
        if (monthOfBirth > currentMonth || (monthOfBirth == currentMonth && dayOfBirth > currentDay)) {
            age--;
        }
        return age;
    }

    public int calculateMaxHeartRate() {
        return 220 - calculateAge(Calendar.getInstance().get(Calendar.YEAR));
    }

    public String calculateTargetHeartRate() {
        int maxRate = calculateMaxHeartRate();
        int minTarget = (int) (maxRate * 0.50);
        int maxTarget = (int) (maxRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    public static void displayBMITable() {
        System.out.println("\nÍndice de Massa Corporal (BMI) - Classificação:");
        System.out.println("Menos de 18.5: Abaixo do peso");
        System.out.println("18.5 - 24.9: Peso normal");
        System.out.println("25.0 - 29.9: Sobrepeso");
        System.out.println("30.0 ou mais: Obesidade");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.nextLine();

        char gender;
        do {
            System.out.print("Digite seu gênero (M/F): ");
            gender = scanner.next().toUpperCase().charAt(0);
        } while (gender != 'M' && gender != 'F');

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = scanner.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = scanner.nextDouble();

        HealthProfile profile = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

        System.out.println("\nPerfil de Saúde:");
        System.out.println("Nome: " + profile.getFirstName() + " " + profile.getLastName());
        System.out.println("Gênero: " + (profile.getGender() == 'M' ? "Masculino" : "Feminino"));
        System.out.println("Data de nascimento: " + day + "/" + month + "/" + year);
        System.out.println("Idade: " + profile.calculateAge(Calendar.getInstance().get(Calendar.YEAR)) + " anos");
        System.out.println("Altura: " + height + " polegadas");
        System.out.println("Peso: " + weight + " libras");
        System.out.printf("Índice de Massa Corporal (BMI): %.1f\n", profile.calculateBMI());
        System.out.println("Frequência cardíaca máxima: " + profile.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + profile.calculateTargetHeartRate());

        displayBMITable();
        scanner.close();
    }
}
