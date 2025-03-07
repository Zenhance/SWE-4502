package Command;

import App.bank;

public class CreateAccountCommand implements Command{

    private bank bank;
    private String accountNumber;
    private double initialDeposit;

    public CreateAccountCommand(bank bank, String accountNumber, double initialDeposit) {
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.initialDeposit = initialDeposit;
    }
    @Override
    public void execute() {
        bank.createAccount(accountNumber, initialDeposit);
    }

    @Override
    public void signature() {
        System.out.println("Created Bank Account at " + accountNumber + " with deposit " + initialDeposit);
    }
}
