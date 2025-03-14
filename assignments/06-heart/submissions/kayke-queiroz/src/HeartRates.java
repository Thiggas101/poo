import java.util.Calendar;
import java.util.Scanner;

public class HeartRates {

    private String firstName;
    private String lastName;
    private int dayOfBirth, monthOfBirth, yearOfBirth;

    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public int getDayOfBirth() { return dayOfBirth; }
    public void setDayOfBirth(int dayOfBirth) { this.dayOfBirth = dayOfBirth; }
    public int getMonthOfBirth() { return monthOfBirth; }
    public void setMonthOfBirth(int monthOfBirth) { this.monthOfBirth = monthOfBirth; }
    public int getYearOfBirth() { return yearOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }

    public int calculateAge() {
        Calendar today = Calendar.getInstance();
        int currentYear = today.get(Calendar.YEAR);
        return calculateAge(currentYear);
    }

    public int calculateAge(int referenceYear) {
        Calendar today = Calendar.getInstance();
        int currentMonth = today.get(Calendar.MONTH) + 1;
        int currentDay = today.get(Calendar.DAY_OF_MONTH);

        int age = referenceYear - yearOfBirth;

        // Se ainda não fez aniversário no ano de referência, subtrai 1
        if (referenceYear == today.get(Calendar.YEAR)) { 
            if (monthOfBirth > currentMonth || (monthOfBirth == currentMonth && dayOfBirth > currentDay)) {
                age--;
            }
        }

        return age;
    }

    public int calculateMaxHeartRate() {
    return 220 - calculateAge(Calendar.getInstance().get(Calendar.YEAR));
}


    public String calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();
        int minTarget = (int) (maxHeartRate * 0.50);
        int maxTarget = (int) (maxHeartRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.nextLine();
        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.print("Digite sua data de nascimento (dia mês ano): ");
        int dayOfBirth = scanner.nextInt();
        int monthOfBirth = scanner.nextInt();
        int yearOfBirth = scanner.nextInt();

        HeartRates person = new HeartRates(firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth);

        System.out.println("\nNome: " + person.getFirstName() + " " + person.getLastName());
        System.out.printf("Data de nascimento: %02d/%02d/%04d\n", person.getDayOfBirth(), person.getMonthOfBirth(), person.getYearOfBirth());
        System.out.println("Idade: " + person.calculateAge() + " anos");
        System.out.println("Frequência cardíaca máxima: " + person.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + person.calculateTargetHeartRate());

        scanner.close();
    }
}
