import java.time.LocalDate;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite seu primeiro nome: ");
    String nome = scanner.nextLine();
    System.out.println("Digite seu sobrenome: ");
    String sobrenome = scanner.nextLine();
    System.out.println("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
    int diaNascimento = scanner.nextInt();
    int mesNascimento = scanner.nextInt();
    int anoNascimento = scanner.nextInt();
    scanner.close();
    HeartRates pessoa = new HeartRates(nome,sobrenome,diaNascimento,mesNascimento,anoNascimento);
    int age = pessoa.calculateAge(LocalDate.now().getYear());
    int maxRate = pessoa.calculateMaxHeartRate();
    String targetRate = pessoa.calculateTargetHeartRate();

    System.out.println("Nome: " + pessoa.getFirstName() + " " + pessoa.getLastName());
    System.out.println("Data de nascimento: " + pessoa.getDayOfBirth()+ "/" + pessoa.getMonthOfBirth() +"/"+ pessoa.getYearOfBirth());
    System.out.println("Idade: " + age + " anos");
    System.out.println("Frequência cardíaca máxima: " + maxRate + "bpm");
    System.out.println("Faixa de frequência cardíaca alvo: " + targetRate);
  }
}
