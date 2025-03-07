package Command;

import App.bank;

public class DepositCommand implements Command{

    private bank bank;
    private String accountNumber;
    private double amount;
    public DepositCommand(bank bank, String accountNumber, double amount) {
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }


    @Override
    public void execute() {
        bank.deposit(accountNumber, amount);
    }

    public void signature() {
        System.out.println("Deposited " + amount + " to Account No. " + accountNumber);
    }
}
