import java.util.Scanner;

class Customer {
    private String firstName;
    private String lastName;
    private String CPF;
    private Account account; 

    public Customer(String firstName, String lastName, String CPF) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.CPF = CPF;
        this.account = new Account(); 
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getCPF() {
        return CPF;
    }
}

class Account {
    private double balance;

    public Account() {
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }
}

public class IDPBank {
    private static Customer cliente;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
        System.out.println("Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:");
        System.out.println("\n1. Abrir conta");
        System.out.println("2. Consultar cliente");
        System.out.println("3. Depositar");
        System.out.println("4. Sacar");
        System.out.println("5. Sair");
        System.out.print("\nDigite o número correspondente à opção desejada: ");
        
        
        
        int opcao = sc.nextInt();
        sc.nextLine(); // Consome quebra de linha
        
        
        String mensagem = switch (opcao) {
            case 1 -> abrirConta(sc);
            case 2 -> "Opção ainda não implementada.";
            case 3 -> "Opção ainda não implementada.";
            case 4 -> "Opção ainda não implementada.";
            case 5 -> {
                System.out.println("Programa encerrando...");
                System.exit(0);
                yield "";
            }
            default -> "Opção inválida. Tente novamente.";
        };

        System.out.println(mensagem);
        }
    }

    public static String abrirConta(Scanner sc) {
        System.out.print("Digite o primeiro nome: ");
        String firstName = sc.nextLine();
        System.out.print("Digite o sobrenome: ");
        String lastName = sc.nextLine();
        System.out.print("Digite o CPF: ");
        String CPF = sc.nextLine();

        cliente = new Customer(firstName, lastName, CPF);
        return "Conta criada com sucesso para " + cliente.getFullName() + "\nCPF:" + cliente.getCPF() + "\n";
    }
}
