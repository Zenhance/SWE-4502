package commands;

import models.BankAccount;

public class DepositCommand implements Command
{
    private BankAccount account;
    private double amount;

    public DepositCommand(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.deposit(amount);
        System.out.println("Deposited $" + amount + " into account " + account.getAccountNumber());
    }
}
