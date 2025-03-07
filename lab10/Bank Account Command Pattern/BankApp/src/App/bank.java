package App;
import Models.Account;
import Models.Transaction;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class bank {
    private Map<String, Account> accounts = new HashMap<>();
     public void createAccount(String accountNumber, double initialDeposite) {
         if(!accounts.containsKey(accountNumber)) {
             accounts.put(accountNumber,new Account(accountNumber,initialDeposite));
             System.out.println("Account " + accountNumber + " created with balance: " + initialDeposite);
         }
         else{
             System.out.println("Account " + accountNumber + " already exists");
         }
     }

     public void deposit(String accountNumber, double amount) {
         if (accounts.containsKey(accountNumber)) {
             accounts.get(accountNumber).deposit(amount);
         }
         else{
             System.out.println("Account " + accountNumber + " does not exist");
         }
     }

     public void withdraw(String accountNumber, double amount) {
         if(accounts.containsKey(accountNumber)){
             accounts.get(accountNumber).withdraw(amount);
         }
         else{
             System.out.println("Account " + accountNumber + " does not exist");
         }
     }

     public void showBalance(String accountNumber) {
         if(accounts.containsKey(accountNumber)){
             System.out.println("Balance for account " + accountNumber + ": " + accounts.get(accountNumber).getBalance());
         }
         else {
             System.out.println("Account " + accountNumber + " does not exist");
         }
     }
    public void showTransactionHistory(String accountNumber) {
         if(accounts.containsKey(accountNumber)){
            System.out.println("Transaction history for account " + accountNumber + ": ");
            for(Transaction transaction : accounts.get(accountNumber).getTransactions()) {
                System.out.println(transaction.getDate() + ": " + transaction.getType() + " - " + transaction.getAmount());
            }
         }
    }

}
