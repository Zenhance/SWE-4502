package commands;
import models.BankAccount;

public class WithdrawCommand implements Command
{
    private BankAccount account;
    private double amount;

    public WithdrawCommand(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        if (account.withdraw(amount)) {
            System.out.println("Withdrew $" + amount + " from account " + account.getAccountNumber());
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }
}
