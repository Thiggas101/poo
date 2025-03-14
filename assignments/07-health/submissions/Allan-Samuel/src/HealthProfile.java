// Nome: Allan Samuel Alves do Monte
// Matrícula: 24101279

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
        this.gender = Character.toUpperCase(gender); // Converte para maiúscula
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    // Método para calcular a idade considerando o mês e o dia (para não dar erro)
    public int calculateAge(int currentYear, int currentMonth, int currentDay) {
        int age = currentYear - yearOfBirth;

        if (monthOfBirth > currentMonth || (monthOfBirth == currentMonth && dayOfBirth > currentDay)) {
            age--; 
        }
        
        return age;
    }

    public int calculateMaxHeartRate() {
        return 220 - calculateAge(2024, 3, 12); // Com a data atual sendo 12 de março de 2024
    }

    public String calculateTargetHeartRate() {
        int maxHR = calculateMaxHeartRate();
        int minTarget = (int) (maxHR * 0.5);
        int maxTarget = (int) (maxHR * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
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

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public double getHeightInInches() {
        return heightInInches;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = scanner.next().charAt(0);
        gender = Character.toUpperCase(gender); // Converte para maiúscula

        System.out.print("Digite sua data de nascimento (dia mês ano): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = scanner.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = scanner.nextDouble();

        HealthProfile profile = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

        int currentYear = 2024;
        int currentMonth = 3; 
        int currentDay = 12;

        int age = profile.calculateAge(currentYear, currentMonth, currentDay);
        int maxHeartRate = profile.calculateMaxHeartRate();
        String targetHeartRate = profile.calculateTargetHeartRate();

        System.out.println("\n--- Informações do Paciente ---");
        System.out.println("Nome: " + profile.getFirstName() + " " + profile.getLastName());
        System.out.println("Gênero: " + (profile.getGender() == 'M' ? "Masculino" : "Feminino"));
        System.out.println("Data de nascimento: " + profile.getDayOfBirth() + "/" + profile.getMonthOfBirth() + "/" + profile.getYearOfBirth());
        System.out.println("Idade: " + age + " anos");
        System.out.println("Altura: " + profile.getHeightInInches() + " polegadas");
        System.out.println("Peso: " + profile.getWeightInPounds() + " libras");
        System.out.printf("Índice de Massa Corporal (BMI): %.1f%n", profile.calculateBMI());
        System.out.println("Frequência cardíaca máxima: " + maxHeartRate + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + targetHeartRate);

        System.out.println("\n--- Tabela de Referência do BMI ---");
        System.out.println("BMI\t\tClassificação");
        System.out.println("Menos de 18.5\tAbaixo do peso");
        System.out.println("18.5 – 24.9\tPeso normal");
        System.out.println("25.0 – 29.9\tSobrepeso");
        System.out.println("30.0 ou mais\tObesidade");

        scanner.close();
    }
}
