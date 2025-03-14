import java.time.LocalDate;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite seu primeiro nome: ");
    String nome = scanner.nextLine();
    System.out.println("Digite seu sobrenome: ");
    String sobrenome = scanner.nextLine();
    System.out.println("Digite seu gênero (M/F): ");
    char genero = scanner.next().charAt(0);
    System.out.println("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
    int diaNascimento = scanner.nextInt();
    int mesNascimento = scanner.nextInt();
    int anoNascimento = scanner.nextInt();
    System.out.println("Digite sua altura em polegadas: ");
    double altura = scanner.nextDouble();
    System.out.println("Digite seu peso em libras: ");
    double peso = scanner .nextDouble();
    scanner.close();
    HealthProfile pessoa = new HealthProfile(nome,sobrenome,genero,diaNascimento,mesNascimento,anoNascimento,altura,peso);
    int age = pessoa.calculateAge(LocalDate.now().getYear());
    int maxRate = pessoa.calculateMaxHeartRate();
    String targetRate = pessoa.calculateTargetHeartRate();

    System.out.println("Nome: " + pessoa.getFirstName() + " " + pessoa.getLastName());
    String generoCompleto = (genero == 'M') ? "Masculino" : "Feminino";
    System.out.println("Gênero: " + generoCompleto);
    System.out.println("Data de nascimento: " + pessoa.getDayOfBirth()+ "/" + pessoa.getMonthOfBirth() +"/"+ pessoa.getYearOfBirth());
    System.out.println("Idade: " + age + " anos");
    System.out.println("Altura: " + pessoa.getHeightInInches() + " polegadas");
    System.out.println("Peso: " + pessoa.getWeightInPounds() + " libras");
    System.out.println("Índice de Massa Corporal (BMI): " + pessoa.calculateBMI());
    System.out.println("Frequência cardíaca máxima: " + maxRate + "bpm");
    System.out.println("Faixa de frequência cardíaca alvo: " + targetRate);
  }
}
