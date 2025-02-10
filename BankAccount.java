
public class BankAccount {
    private double balance; // Private: Balance should not be accessible outside this class.

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        } else {
            this.balance = initialBalance;
        }
    }

    public void deposit(double amount) { // Public, for anyone to be able to deposit money
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of Rs. " + amount + " successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    protected void withdraw(double amount) { // Protected, which is acessible within the package and subclasses.
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of Rs. " + amount + " successful.");
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    void checkBalance() { // Accessible only within the same package.
        System.out.println("Current balance: Rs. " + balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        
        account.deposit(500);      // Public - Accessible anywhere
        account.checkBalance();    
        account.withdraw(200);     // Protected - Accessible (same package)
     
        // account.balance = 2000; // Compilation error
    }
}
