package Models;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;
    public Account(String accountNumber, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        this.transactions = new ArrayList<>();
        transactions.add(new Transaction("Deposit", initialDeposit));

    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public void deposit(double amount) {
        this.balance += amount;
        transactions.add(new Transaction("Deposit", amount));
        System.out.println("Deposited " + amount + " into " + accountNumber + ". New balance: " + balance);

    }
    public void withdraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount));
            System.out.println("Withdrawn " + amount + " from " + accountNumber + ". New balance: " + balance);
        }
        else{
            System.out.println("Insufficient balance");
        }
    }
}
