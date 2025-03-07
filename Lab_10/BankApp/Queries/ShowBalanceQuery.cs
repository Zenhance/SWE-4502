using BankApp.App;

namespace BankApp.Queries;

public class ShowBalanceQuery : IQuery
{
    private Bank _bank;
    private string _accountNumber;

    public ShowBalanceQuery(Bank bank, string accountNumber)
    {
        _bank = bank;
        _accountNumber = accountNumber;
    }

    public void Query()
    {
        _bank.ShowBalance(_accountNumber);
    }
}