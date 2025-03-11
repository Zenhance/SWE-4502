package commands;
import models.BankAccount;
import repository.BankRepository;

public class CreateAccountCommand implements Command
{
    private BankRepository repository;
    private String accountNumber;
    private String accountHolder;
    private double initialDeposit;

    public CreateAccountCommand(BankRepository repository, String accountNumber, String accountHolder, double initialDeposit)
    {
        this.repository = repository;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.initialDeposit = initialDeposit;
    }
    @Override
    public void execute()
    {
        if (!repository.accountExists(accountNumber)) {
            BankAccount newAccount = new BankAccount(accountNumber, accountHolder, initialDeposit);
            repository.addAccount(newAccount);
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account with this number already exists.");
        }
    }
}
