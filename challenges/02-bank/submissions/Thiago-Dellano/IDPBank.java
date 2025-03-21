import java.util.Scanner;

public class IDPBank {
    private static Customer customer = null;
    private static Account account = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nSeja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Sair");
            System.out.print("\nDigite o número correspondente à opção desejada: ");
            
            while (!sc.hasNextInt()) {
                System.out.println("Opção inválida. Tente novamente.");
                System.out.print("Digite o número correspondente à opção desejada: ");
                sc.next();
            }
            option = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            switch (option) {
                case 1:
                    System.out.println("\nDigite os dados para a abertura da conta.");
                    System.out.print("Primeiro nome: ");
                    String firstName = sc.nextLine();
                    System.out.print("Sobrenome: ");
                    String lastName = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    customer = createCustomer(firstName, lastName, cpf);
                    account = openAccount(customer);

                    System.out.println("\nCliente cadastrado com sucesso!\n");
                    System.out.println(customer.displayInformation());
                    System.out.println("\nConta criada com sucesso! Pressione Enter para continuar...");
                    sc.nextLine();
                    break;

                case 2:
                    if (customer != null) {
                        System.out.println("\n" + customer.displayInformation());
                    } else {
                        System.out.println("\nNenhum cliente cadastrado.");
                    }
                    System.out.println("\nPressione Enter para continuar...");
                    sc.nextLine();
                    break;

                case 3:
                    if (account != null) {
                        System.out.print("\nDigite o valor que deseja depositar.\n\nValor: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();
                        deposit(amount);
                        System.out.println("\nValor depositado com sucesso na conta do cliente " + customer.getFirstName() + " " + customer.getLastName() + ".");
                        System.out.println(customer.displayInformation());
                    } else {
                        System.out.println("\nNenhuma conta encontrada.");
                    }
                    System.out.println("\nPressione Enter para continuar...");
                    sc.nextLine();
                    break;

                case 4:
                    if (account != null) {
                        System.out.print("\nDigite o valor que deseja sacar.\n\nValor: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();
                        withdraw(amount);
                        System.out.println("\nValor sacado com sucesso da conta do cliente " + customer.getFirstName() + " " + customer.getLastName() + ".");
                        System.out.println(customer.displayInformation());
                    } else {
                        System.out.println("\nNenhuma conta encontrada.");
                    }
                    System.out.println("\nPressione Enter para continuar...");
                    sc.nextLine();
                    break;

                case 5:
                    System.out.println("\nObrigado por usar o IDP Bank. Até logo!");
                    break;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.\n");
            }

        } while (option != 5);

        sc.close();
    }

    public static Customer createCustomer(String firstName, String lastName, String cpf) {
        return new Customer(firstName, lastName, cpf);
    }

    public static Account openAccount(Customer customer) {
        Account acc = new Account();
        customer.addAccount(acc);
        return acc;
    }

    public static void deposit(double amount) {
        if (account != null) {
            account.deposit(amount);
        }
    }

    public static void withdraw(double amount) {
        if (account != null) {
            account.withdraw(amount);
        }
    }
}
