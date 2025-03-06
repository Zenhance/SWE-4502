import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private double balance;
    private String accountNumber;
    private String customerName;

    private List<Transaction> transactions;

    public BankAccount (String accountNumber, String customerName, double initialDeposit ){

        this.accountNumber=accountNumber;
        this.customerName=customerName;
        this.balance=initialDeposit;
        this.transactions = new ArrayList<>();

        addTransaction(TransactionType.DEPOSIT, initialDeposit, "Initial deposit");



    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void deposit(double amount){
        if (amount <= 0){
            System.out.println("Invalid amount");
            return;
        }
        balance += amount;

        addTransaction(TransactionType.DEPOSIT, amount, "Deposit");


    }

    public void withdraw(double amount){
        if (amount <= 0){
            System.out.println("Invalid amount");
            return;
        }
        if (amount > balance){
            System.out.println("Insufficient funds");
            return;
        }
        balance -= amount;

        addTransaction(TransactionType.WITHDRAWAL, amount, "Withdrawal");
    }


    public void addTransaction(TransactionType type, double amount, String reference){
        Transaction transaction = new Transaction(type, accountNumber, amount, reference);
        if (transactions == null){
            transactions = new ArrayList<>();
        }
        transactions.add(transaction);


    }

    public List<Transaction> getTransactions(){
        return transactions;
    }

}
