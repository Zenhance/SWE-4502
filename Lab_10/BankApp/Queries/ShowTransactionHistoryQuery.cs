using BankApp.App;

namespace BankApp.Queries;

public class ShowTransactionHistoryQuery : IQuery
{
    private Bank _bank;
    private string _accountNumber;

    public ShowTransactionHistoryQuery(Bank bank, string accountNumber)
    {
        _bank = bank;
        _accountNumber = accountNumber;
    }

    public void Query()
    {
        _bank.ShowTransactionHistory(_accountNumber);
    }
}