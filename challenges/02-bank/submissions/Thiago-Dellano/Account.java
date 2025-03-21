import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private static int accountCounter = 1000;
    private int id;
    private double balance;

    public Account() {
        this.id = ++accountCounter;
        this.balance = 0.0;
    }

    public int getId() {
        return id;
    }

    public String getBalance() {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return format.format(balance);
    }

    public void setBalance(double amount) {
        if (amount >= 0) {
            this.balance = amount;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
        }
    }
}
