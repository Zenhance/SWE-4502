import java.util.*;
class CreateAccountCommand implements Command {
    private final Map<Integer, BankAccount> accounts;
    private final int id;
    private final String owner;
    private final double initialDeposit;

    public CreateAccountCommand(Map<Integer, BankAccount> accounts, int id, String owner, double initialDeposit) {
        this.accounts = accounts;
        this.id = id;
        this.owner = owner;
        this.initialDeposit = initialDeposit;
    }

    @Override
    public void execute() {
        if (!accounts.containsKey(id)) {
            accounts.put(id, new BankAccount(id, owner, initialDeposit));
            System.out.println("Account " + id + " created for " + owner + " with " + initialDeposit);
        } else {
            System.out.println("Account ID already exists.");
        }
    }
}