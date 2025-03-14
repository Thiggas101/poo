import java.util.Scanner;
import java.time.Year;

// Classe HeartRates
class HeartRates {
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    // Construtor
    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    // Métodos get e set
    public String getFirstName() {
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

    // Método para calcular a idade
    public int calculateAge() {
        int currentYear = Year.now().getValue();
        return currentYear - yearOfBirth;
    }

    // Método para calcular a frequência cardíaca máxima
    public int calculateMaxHeartRate() {
        return 220 - calculateAge();
    }

    // Método para calcular a faixa de frequência cardíaca alvo
    public String calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();
        double minTarget = maxHeartRate * 0.50;
        double maxTarget = maxHeartRate * 0.85;
        return String.format("%.0f bpm - %.0f bpm", minTarget, maxTarget);
    }
}

// Classe principal
public class HeartRatesCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicita os dados do usuário
        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.next();
        
        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.next();
        
        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        
        // Cria o objeto HeartRates
        HeartRates person = new HeartRates(firstName, lastName, day, month, year);
        
        // Exibe as informações do usuário
        System.out.println("\nNome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Data de nascimento: " + person.getDayOfBirth() + "/" + person.getMonthOfBirth() + "/" + person.getYearOfBirth());
        System.out.println("Idade: " + person.calculateAge() + " anos");
        System.out.println("Frequência cardíaca máxima: " + person.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + person.calculateTargetHeartRate());

        scanner.close();
    }
}
