package Balance;

public class Account {
    private double balance;

    // Constructor
    public Account(double balance) {
        this.balance = balance;
    }

    // Method
    public void Display_Balance() {
        System.out.println("The account's balance is: " + balance);
    }
}
