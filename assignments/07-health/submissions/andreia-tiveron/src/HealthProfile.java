import java.util.Scanner;

public class HealthProfile{
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    public HealthProfile(String firstName, String lastName, char gender, int dayOfBirth, int monthOfBirth, int yearOfBirth, double heightInInches, double weightInPounds){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }
    
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public double getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(double heightInInches) {
        this.heightInInches = heightInInches;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public int calculateAge(int currentYear) {
        return currentYear - this.yearOfBirth;
    }

    public int calculateMaxHeartRate() {
        return 220 - calculateAge(2025); 
    }

    public String calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();
        int minTarget = (int)(maxHeartRate * 0.50);
        int maxTarget = (int)(maxHeartRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public double calculateBMI(){
        return (weightInPounds * 703)/ (heightInInches*heightInInches);
    }

    public String getBMICategory() {
        double bmi = calculateBMI();
        if (bmi < 18.5) {
            return "Abaixo do peso";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Peso normal";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidade";
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = input.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = input.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = input.nextDouble();

        HealthProfile person = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

        int currentYear = 2025;

        System.out.println("\nNome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Gênero: " + (person.getGender() == 'M' ? "Masculino" : "Feminino"));
        System.out.println("Data de nascimento: " + person.getDayOfBirth() + "/" + person.getMonthOfBirth() + "/" + person.getYearOfBirth());
        System.out.println("Idade: " + person.calculateAge(currentYear) + " anos");
        System.out.println("Altura: " + person.getHeightInInches() + " polegadas");
        System.out.println("Peso: " + person.getWeightInPounds() + " libras");

        double bmi = person.calculateBMI();
        System.out.printf("Índice de Massa Corporal(BMI): %.1f\n", bmi);

        System.out.print("Classificação do BMI: " + person.getBMICategory());
        int maxHeartRate = person.calculateMaxHeartRate();
        String targetHeartRate = person.calculateTargetHeartRate();

        System.out.println("\nFrequência cardíaca máxima: " + maxHeartRate + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + targetHeartRate);

        System.out.println("\nTabela de Referência do BMI:");
        System.out.println("BMI\tClassificação");
        System.out.println("< 18.5\t     Abaixo do peso");
        System.out.println("18.5 - 24.9\tPeso normal");
        System.out.println("25.0 – 29.9\tSobrepeso");
        System.out.println(">= 30.0\tObesidade");

        input.close();
    }
    
}
