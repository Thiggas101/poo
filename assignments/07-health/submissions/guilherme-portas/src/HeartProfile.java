import java.time.LocalDate;
import java.util.Scanner;

public class HeartProfile {
    private String firstName, lastName;
    private char gender;
    private int dayOfBirth, monthOfBirth, yearOfBirth;
    private double heightInInches, weightInPounds;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.print("Digite seu Gênero (M/F): ");
        char gender = scanner.next().charAt(0);
        if(gender != 'm' && gender != 'M' && gender != 'f' && gender != 'F') {
            scanner.close();
            throw new java.lang.Error("Gênero inválido");
        }

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int dayOfBirth = scanner.nextInt(),
            monthOfBirth = scanner.nextInt(),
            yearOfBirth = scanner.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double heightInInches = scanner.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weightInPounds = scanner.nextDouble();

        HeartProfile hp = new HeartProfile(firstName, lastName, gender, dayOfBirth, monthOfBirth, yearOfBirth, heightInInches, weightInPounds);

        System.out.println("Nome: " + hp.getFirstName() + " " + hp.getLastName());
        System.out.println("Gênero: " + hp.getGender());
        System.out.println("Data de nascimento: " + hp.getDayOfBirth() + "/" + hp.getMonthOfBirth() + "/" + hp.getYearOfBirth());
        System.out.println("Idade: " + hp.calculateAge(2025));
        System.out.println("Altura: " + hp.getHeightInInches() + " Polegadas");
        System.out.println("Peso: " + hp.getWeightInPounds() + " Libras");
        System.out.printf("Índice de Massa Corporal (BMI): %.1f \n", hp.calculateBMI());
        System.out.println("Frequência cardíaca máxima: " + hp.calculateMaxHeartRate());
        System.out.println("Faixa de frequência cardíaca alvo: " + hp.calculateTargetHeartRate());
        System.out.printf(  "%-13s Classificação \n" + 
                            "%-13s Abaixo do peso \n" + 
                            "%-13s Peso normal \n" +
                            "%-13s Sobrepeso \n" +
                            "%-13s Obesidade \n", 
                            "BMI", "Menos de 18.5", "18.5 - 24.9", "25.0 - 29.9", "30.0 ou mais");

        ////System.out.printf("%s, %s, %d, %d, %d", firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth);
        
        scanner.close();
    }

    public HeartProfile (String firstName, String lastName, char gender, int dayOfBirth, int monthOfBirth, int yearOfBirth, double heightInInches, double weightInPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    public String getFirstName () {
        return this.firstName;
    }

    public String getLastName () {
        return this.lastName;
    }

    public String getGender () {
        if (this.gender == 'm' || this.gender == 'M') return "Masculino";
        else return "Feminino";
    }
    
    public int getDayOfBirth () {
        return this.dayOfBirth;
    }
    
    public int getMonthOfBirth () {
        return this.monthOfBirth;
    }

    public int getYearOfBirth () {
        return this.yearOfBirth;
    }

    public double getHeightInInches () {
        return this.heightInInches;
    }

    public double getWeightInPounds () {
        return this.weightInPounds;
    }

    public int calculateAge (int currentYear) {
        int idade;
        if (this.yearOfBirth > currentYear) {
            throw new java.lang.Error("Data de nascimento impossível ou ano atual inválido.");
        }
        else {
            idade = currentYear - this.yearOfBirth; 
            if (LocalDate.now().getMonthValue() < this.monthOfBirth) idade--;
        }
        return idade;
    }

    public int calculateMaxHeartRate () {
        return 220 - this.calculateAge(2025);
    }

    public String calculateTargetHeartRate () {
        int max = calculateMaxHeartRate();
        return (int) (max * 0.5) + " bpm - " + (int) (max * 0.85) + " bpm";
    }

    public double calculateBMI() {
        return this.weightInPounds * 703 / (this.heightInInches * this.heightInInches);
    }
}