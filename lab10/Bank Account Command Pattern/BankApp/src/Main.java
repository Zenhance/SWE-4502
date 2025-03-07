import App.bank;
import Executors.CommandExecutor;
import Command.CreateAccountCommand;
import Command.DepositCommand;
import Executors.QueryExecutor;
import Query.ShowTransactionHistoryQuery;

public class Main {
    public static void main(String[] args) {
        bank lolBank = new bank();
        CommandExecutor commandExecutor = new CommandExecutor();
        QueryExecutor queryExecutor = new QueryExecutor();

        // Create First Account
        CreateAccountCommand createAccountCommand1 = new CreateAccountCommand(lolBank, "ABC", 100);
        commandExecutor.executeCommand(createAccountCommand1);

        // Create Second Account
        CreateAccountCommand createAccountCommand2 = new CreateAccountCommand(lolBank, "XYZ", 200);
        commandExecutor.executeCommand(createAccountCommand2);

        // Deposit 500 to first account
        DepositCommand depositCommand1 = new DepositCommand(lolBank, "ABC", 500);
        commandExecutor.executeCommand(depositCommand1);

        // Transaction History of first account - ABC
        ShowTransactionHistoryQuery showTransactionHistoryQuery1 = new ShowTransactionHistoryQuery(lolBank, "ABC");
        queryExecutor.executeQuery(showTransactionHistoryQuery1);

        // Transaction History of second account - XYZ
        ShowTransactionHistoryQuery showTransactionHistoryQuery2 = new ShowTransactionHistoryQuery(lolBank, "XYZ");
        queryExecutor.executeQuery(showTransactionHistoryQuery2);

        // Print command history
        commandExecutor.commandHistory();
    }
}
