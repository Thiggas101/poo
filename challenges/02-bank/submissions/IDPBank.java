import java.util.Scanner;

public class IDPBank {
    private static int accountCounter = 1001;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nSeja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Sair");
            System.out.print("Digite o número correspondente à opção desejada: ");
            
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 1:
                    Customer customer = createCustomer();
                    Account account = openAccount(customer);
                    customer.addAccount(account);
                    System.out.println("\nConta criada com sucesso! Pressione Enter para continuar...");
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.println("\nConsultar cliente não implementado nesta versão.");
                    break;
                case 3:
                    System.out.println("\nDepositar não implementado nesta versão.");
                    break;
                case 4:
                    System.out.println("\nSacar não implementado nesta versão.");
                    break;
                case 5:
                    System.out.println("\nObrigado por usar o IDP Bank. Encerrando o programa.");
                    return;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
    }

    public static Customer createCustomer() {
        System.out.println("\nDigite os dados para a abertura da conta.");
        System.out.print("Primeiro nome: ");
        String firstName = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String lastName = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        return new Customer(firstName, lastName, cpf);
    }

    public static Account openAccount(Customer customer) {
        return new Account(accountCounter++);
    }
}

class Customer {
    private String firstName;
    private String lastName;
    private String cpf;
    private Account account;

    public Customer(String firstName, String lastName, String cpf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
    }

    public boolean addAccount(Account account) {
        if (this.account == null) {
            this.account = account;
            System.out.println("\nCliente cadastrado com sucesso!");
            System.out.println("Nome: " + firstName + " " + lastName);
            System.out.println("CPF: " + cpf);
            System.out.println("Número da Conta: " + account.getId());
            System.out.println("Saldo: " + account.getFormattedBalance());
            return true;
        }
        return false;
    }
}

class Account {
    private int id;
    private double balance;

    public Account(int id) {
        this.id = id;
        this.balance = 0.0;
    }

    public int getId() {
        return id;
    }

    public String getFormattedBalance() {
        return String.format("R$ %.2f", balance);
    }
}
