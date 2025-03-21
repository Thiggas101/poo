import java.util.Scanner;

// Classe que representa a Conta Poupança
public class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate;

    // Construtor
    public SavingsAccount(double savingsBalance) {
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    // Método para calcular juros mensais
    public void calculateMonthlyInterest() {
        double monthlyRate = Math.pow((1 + annualInterestRate / 100), (1.0 / 12)) - 1;
        savingsBalance += savingsBalance * monthlyRate;
    }

    // Método para obter o saldo atual
    public double getSavingsBalance() {
        return savingsBalance;
    }

    // Método para definir a taxa de juros anual
    public static void setAnnualInterestRate(double newRate) {
        if (newRate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = newRate;
    }
}

// Classe principal que executa o programa
public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o saldo inicial
        System.out.print("Informe o saldo inicial: ");
        double initialBalance = scanner.nextDouble();

        // Solicita a taxa de juros anual
        System.out.print("Informe a taxa de juros anual (%): ");
        double initialRate = scanner.nextDouble();

        // Cria a conta poupança
        SavingsAccount account = new SavingsAccount(initialBalance);
        SavingsAccount.setAnnualInterestRate(initialRate);

        // Exibe os saldos ao longo de 12 meses
        System.out.println("\nSaldos com taxa de juros de " + initialRate + "%:");
        for (int i = 1; i <= 12; i++) {
            account.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", i, account.getSavingsBalance());
        }

        // Solicita nova taxa de juros
        System.out.print("\nInforme a nova taxa de juros anual (%): ");
        double newRate = scanner.nextDouble();
        SavingsAccount.setAnnualInterestRate(newRate);

        // Calcula e exibe o saldo após mais um mês
        System.out.println("\nAlterando taxa de juros anual para " + newRate + "%...");
        account.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f%n", account.getSavingsBalance());

        scanner.close();
    }
}