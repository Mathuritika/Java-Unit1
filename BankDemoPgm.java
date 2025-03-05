interface Bank {
    void deposit(double amount);
    void withdraw(double amount);
}

class Account implements Bank {
    double balance;
    Account(double balance) {
        this.balance = balance;
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited amount: " + amount + ", New balance: " + balance);
    }
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Balance is not sufficient");
        } else {
            balance -= amount;
            System.out.println("Withdrawn amount: " + amount + ", New balance: " + balance);
        }
    }
}

public class BankDemoPgm {
    public static void main(String[] args) {
        Account acc = new Account(1000);
        acc.deposit(200);
        acc.withdraw(400);
        acc.withdraw(1000);
    }
}
