using BankApp.App;

namespace BankApp.Commands;

public class WithdrawCommand : ICommand
{
    private Bank _bank;
    private string _accountNumber;
    private decimal _amount;

    public WithdrawCommand(Bank bank, string accountNumber, decimal amount)
    {
        _bank = bank;
        _accountNumber = accountNumber;
        _amount = amount;
    }

    public void Execute()
    {
        _bank.Withdraw(_accountNumber, _amount);
    }
    
    public void Signature()
    {
        Console.WriteLine($"Withdrawn {_amount} from Account No. {_accountNumber}");
    }
}