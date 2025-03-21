public class Customer {
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
            return true;
        }
        return false;
    }

    public String displayInformation() {
        return "Nome: " + firstName + " " + lastName +
               "\nCPF: " + cpf +
               "\nNúmero da Conta: " + account.getId() +
               "\nSaldo: " + account.getBalance();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
