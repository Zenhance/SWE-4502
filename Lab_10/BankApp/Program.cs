using BankApp.App;
using BankApp.Commands;
using BankApp.Executor;
using BankApp.Queries;

class Program
{
    public static void Main()
    {
        Bank lolBank = new Bank();
        CommandExecutor commandExecutor = new CommandExecutor();
        QueryExecutor queryExecutor = new QueryExecutor();

        // Create First Account
        CreateAccountCommand createAccountCommand1 = new CreateAccountCommand(lolBank, "ABC", 100);
        commandExecutor.ExecuteCommand(createAccountCommand1);
        
        // Create Second Account
        CreateAccountCommand createAccountCommand2 = new CreateAccountCommand(lolBank, "XYZ", 200);
        commandExecutor.ExecuteCommand(createAccountCommand2);
        
        // Deposit 100 taka to first account
        DipositCommand dipositCommand1 = new DipositCommand(lolBank, "ABC", 500);
        commandExecutor.ExecuteCommand(dipositCommand1);
        
        
        // Transaction History of first account - ABC
        ShowTransactionHistoryQuery showTransactionHistoryQuery1 = new ShowTransactionHistoryQuery(lolBank, "ABC");
        queryExecutor.ExecuteQuery(showTransactionHistoryQuery1);
        
        
        // Transaction History of second Account - XYZ
        ShowTransactionHistoryQuery showTransactionHistoryQuery2 = new ShowTransactionHistoryQuery(lolBank, "XYZ");
        queryExecutor.ExecuteQuery(showTransactionHistoryQuery2);

        
        
        commandExecutor.CommandHistory();
    }   
    
}