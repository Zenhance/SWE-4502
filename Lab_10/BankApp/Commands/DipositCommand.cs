using BankApp.App;

namespace BankApp.Commands;

public class DipositCommand : ICommand
{
    private Bank _bank;
    private string _accountNumber;
    private decimal _amount;

    public DipositCommand(Bank bank, string accountNumber, decimal amount)
    {
        _bank = bank;
        _accountNumber = accountNumber;
        _amount = amount;
    }

    public void Execute()
    {
        _bank.Deposit(_accountNumber, _amount);
    }
    
    public void Signature()
    {
        Console.WriteLine($"Diposited {_amount} to Account No. {_accountNumber}");
    }
}