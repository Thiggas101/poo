import java.util.Scanner;

class IDPBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = null;
        Account account = null;

        while (true) {
            System.out.println("\nSeja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Sair");
            System.out.print("Digite o número correspondente à opção desejada: ");
            
            int option;
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Opção inválida. Tente novamente.");
                scanner.nextLine(); 
                continue;
            }

            switch (option) {
                case 1:
                    System.out.println("\nDigite os dados para a abertura da conta.");
                    System.out.print("Primeiro nome: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Sobrenome: ");
                    String lastName = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    customer = new Customer(firstName, lastName, cpf);
                    account = new Account();
                    customer.setAccount(account);

                    System.out.println("\nCliente cadastrado com sucesso!");
                    System.out.println(customer.displayInformation());
                    System.out.println("\nConta criada com sucesso! Pressione Enter para continuar...");
                    scanner.nextLine();
                    break;

                case 2:
                    if (customer != null) {
                        System.out.println(customer.displayInformation());
                    } else {
                        System.out.println("Nenhum cliente cadastrado ainda.");
                    }
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                    break;

                case 3:
                    if (account != null) {
                        System.out.print("Digite o valor que deseja depositar: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        if (amount > 0) {
                            account.deposit(amount);
                              System.out.println("\nValor depositado com sucesso na conta do cliente " + customer.getFullName() + ".");
                              System.out.println(customer.displayInformation());
                        } else {
                            System.out.println("Valor inválido para depósito.");
                        }
                    } else {
                        System.out.println("Nenhuma conta encontrada.");
                    }
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                    break;

                case 4:
                    if (account != null) {
                        System.out.print("Digite o valor que deseja sacar: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        if (amount > 0 && account.withdraw(amount)) {
                            System.out.println("\nValor sacado com sucesso da conta do cliente " + customer.getFullName() + ".");
                            System.out.println(customer.displayInformation());
                        } else {
                            System.out.println("Saldo insuficiente ou valor inválido.");
                        }
                    } else {
                        System.out.println("Nenhuma conta encontrada.");
                    }
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                    break;

                case 5:
                    System.out.println("Obrigado por usar o IDP Bank. Até logo!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
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

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String displayInformation() {
        return "\nNome: " + firstName + " " + lastName + "\n" +
               "CPF: " + cpf + "\n" +
               (account != null ? account.toString() : "Nenhuma conta cadastrada.");
    }
}

class Account {
    private static int accountCounter = 1000;
    private int id;
    private double balance;

    public Account() {
        this.id = ++accountCounter;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Número da Conta: " + id + "\n" +
               "Saldo: R$ " + String.format("%.2f", balance);
    }
}
