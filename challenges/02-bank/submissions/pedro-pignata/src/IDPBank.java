import java.util.Scanner;

public class IDPBank {
    public static void main(String[] args){
        while (true){
            System.out.println(""
            +"Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:\n\n"
            +"1. Abrir conta \n"
            +"2. Consultar cliente \n"
            +"3. Depositar \n"
            +"4. Sacar \n"
            +"5. Sair \n\n"
            +"Digite o número correspondente à opção desejada: ");
            Scanner scanner = new Scanner(System.in);

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                createCustomer();
                break;

                case 2: 
                consultarCliente();
                break;

                case 3:
                depositar();
                break;

                case 4:
                sacar();
                break;

                case 5:
                System.out.println("Obrigado por usar o IDP Bank.");
                return; 

                default:
                System.out.println(""
                +"Opção inválida. Tente novamente.\n"
                +"Digite o número correspondente à opção desejada: ");
            }
        }
    }

    public static void createCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite os dados para a abertura da conta.\n");

        System.out.println("Primeiro nome: ");
        String firstName = scanner.nextLine();

        System.out.println("Sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.println("CPF: ");
        String cpf = scanner.nextLine();


        Customer createCustomer = new Customer(firstName, lastName, cpf);
        return Customer;

        Account openAccount = new Account(Customer);
        return Account;
        
        
        System.out.println("\nCliente cadastrado com sucesso!\n");
        System.out.println(createCustomer.displayInformation());
        }

    public static void consultarCliente() {

        
    }



}