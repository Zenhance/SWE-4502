package Command;

import App.bank;

public class WithdrawCommand implements Command {

    private App.bank bank;
    private String accountNumber;
    private double amount;
    public WithdrawCommand(bank bank, String accountNumber, double amount) {
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }


    @Override
    public void execute() {
        bank.deposit(accountNumber, amount);
    }

    public void signature() {
        System.out.println("Withdrawn " + amount + " from Account No. " + accountNumber);
    }


}
