import java.util.Scanner;
import java.time.LocalDate;

public class HeartRates {
    private String firstName, lastName;
    private int dayOfBirth, monthOfBirth, yearOfBirth;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int dayOfBirth = scanner.nextInt(),
            monthOfBirth = scanner.nextInt(),
            yearOfBirth = scanner.nextInt();
        
        HeartRates hr = new HeartRates(firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth);

        System.out.println("Nome: " + hr.getFirstName() + " " + hr.getLastName());
        System.out.println("Data de nascimento: " + hr.getDayOfBirth() + "/" + hr.getMonthOfBirth() + "/" + hr.getYearOfBirth());
        System.out.println("Idade: " + hr.calculateAge(2025));
        System.out.println("Frequência cardíaca máxima: " + hr.calculateMaxHeartRate());
        System.out.println("Faixa de frequência cardíaca alvo: " + hr.calculateTargetHeartRate());

        ////System.out.printf("%s, %s, %d, %d, %d", firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth);
        
        scanner.close();
    }

    public HeartRates (String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public String getFirstName () {
        return firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public int getDayOfBirth () {
        return dayOfBirth;
    }

    public int getMonthOfBirth () {
        return monthOfBirth;
    }

    public int getYearOfBirth () {
        return yearOfBirth;
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
}