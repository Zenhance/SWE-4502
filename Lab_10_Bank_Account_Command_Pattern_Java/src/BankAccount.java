import java.util.*;

// Receiver
class BankAccount {
    private final int id;
    private final String owner;
    private double balance;
    private final List<String> transactionHistory = new ArrayList<>();

    public BankAccount(int id, String owner, double initialDeposit) {
        this.id = id;
        this.owner = owner;
        this.balance = initialDeposit;
        transactionHistory.add("Account created with balance: " + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
            return true;
        }
        transactionHistory.add("Withdrawal failed: Insufficient funds");
        return false;
    }

    public double getBalance() { return balance; }
    public List<String> getTransactionHistory() { return transactionHistory; }
    public int getId() { return id; }
}