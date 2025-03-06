import java.util.List;
import java.util.Map;

public class CreateAccountCommand implements Command{

    private Map<String, BankAccount> accounts;
    private String accountNumber;
    private String customerName;
    private double initialDeposit;

    public CreateAccountCommand(Map<String, BankAccount> accounts, String accountNumber, String customerName, double initialDeposit){
        this.accounts = accounts;
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.initialDeposit = initialDeposit;
    }

    @Override
    public void execute() {
        BankAccount account = new BankAccount(accountNumber, customerName, initialDeposit);
        accounts.put(accountNumber, account);

        System.out.println("Account created "+accountNumber+" "+customerName+" "+initialDeposit);
    }




}
