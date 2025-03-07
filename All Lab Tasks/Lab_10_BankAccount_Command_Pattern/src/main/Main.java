package main;
import commands.CreateAccountCommand;
import commands.DepositCommand;
import commands.WithdrawCommand;
import invoker.CommandInvoker;
import models.BankAccount;
import repository.BankRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankRepository repository = new BankRepository();
        CommandInvoker invoker = new CommandInvoker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Banking System ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Balance");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNumber = scanner.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String holder = scanner.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double deposit = scanner.nextDouble();
                    invoker.executeCommand(new CreateAccountCommand(repository, accNumber, holder, deposit));
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNumber = scanner.nextLine();
                    BankAccount depositAccount = repository.getAccount(accNumber);
                    if (depositAccount != null) {
                        System.out.print("Enter Deposit Amount: ");
                        deposit = scanner.nextDouble();
                        invoker.executeCommand(new DepositCommand(depositAccount, deposit));
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accNumber = scanner.nextLine();
                    BankAccount withdrawAccount = repository.getAccount(accNumber);
                    if (withdrawAccount != null) {
                        System.out.print("Enter Withdrawal Amount: ");
                        double withdraw = scanner.nextDouble();
                        invoker.executeCommand(new WithdrawCommand(withdrawAccount, withdraw));
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    accNumber = scanner.nextLine();
                    BankAccount account = repository.getAccount(accNumber);
                    if (account != null) {
                        System.out.println("Current Balance: $" + account.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    accNumber = scanner.nextLine();
                    account = repository.getAccount(accNumber);
                    if (account != null) {
                        System.out.println("Transaction History:");
                        for (String transaction : account.getTransactionHistory()) {
                            System.out.println(transaction);
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
