import java.util.*;
// Client
public class Main {
    public static void main(String[] args) {
        Map<Integer, BankAccount> accounts = new HashMap<>();
        BankInvoker invoker = new BankInvoker();

        // Creating account
        Command createCommand = new CreateAccountCommand(accounts, 1, "John Doe", 500);
        invoker.setCommand(createCommand);
        invoker.executeCommands();

        // Deposit money
        Command depositCommand = new DepositCommand(accounts.get(1), 200);
        invoker.setCommand(depositCommand);
        invoker.executeCommands();

        // Withdraw money
        Command withdrawCommand = new WithdrawCommand(accounts.get(1), 100);
        invoker.setCommand(withdrawCommand);
        invoker.executeCommands();

        // Display balance
        System.out.println("Current balance: " + accounts.get(1).getBalance());

        // Display transaction history
        System.out.println("Transaction history:");
        for (String entry : accounts.get(1).getTransactionHistory()) {
            System.out.println(entry);
        }
    }
}
