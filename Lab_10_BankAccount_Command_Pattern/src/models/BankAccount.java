package models;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountNumber, String accountHolder, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial deposit: $" + initialDeposit);
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: $" + amount);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
            return true;
        }
        transactionHistory.add("Withdrawal failed. Insufficient balance.");
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
