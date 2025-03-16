import java.util.Scanner;

    class Account {
    private int id;
    private double balance;

    public Account(int id, double balance){
        this.id = id; 
        this.balance = 0.0;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(){
        this.balance = 0.0;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    // public void setBalance(double balance) {
    //     this.balance = balance;
    // }
}
