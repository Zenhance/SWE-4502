import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {

    private Map<String, BankAccount> accounts= new HashMap<>();

    public void executeCommand(Command command) {
        command.execute();
    }

    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }


    public Map<String, BankAccount> getAccounts() {
        return accounts;
    }



}
