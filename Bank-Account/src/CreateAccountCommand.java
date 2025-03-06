import java.util.Map;
import java.util.Random;

public class CreateAccountCommand implements Command {

    private Map<String, BankAccount> accounts;
    private String customerName;
    private double initialDeposit;

    public CreateAccountCommand(Map<String, BankAccount> accounts, String customerName, double initialDeposit) {
        this.accounts = accounts;
        this.customerName = customerName;
        this.initialDeposit = initialDeposit;
    }

    @Override
    public void execute() {
        String accountNumber = generateUniqueAccountNumber();
        BankAccount account = new BankAccount(accountNumber, customerName, initialDeposit);
        accounts.put(accountNumber, account);

        System.out.println("Account created " + accountNumber + " " + customerName + " " + initialDeposit);
    }

    private String generateUniqueAccountNumber() {
        Random random = new Random();
        String accountNumber;

        do {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                sb.append(random.nextInt(10));
            }
            accountNumber = sb.toString();

           
        } while (accounts.containsKey(accountNumber));

        return accountNumber;
    }
}