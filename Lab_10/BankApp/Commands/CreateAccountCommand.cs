using System.Threading.Channels;
using BankApp.App;

namespace BankApp.Commands;

public class CreateAccountCommand : ICommand
{
    private Bank _bank;
    private string _accountNumber;
    private decimal _initialDeposit;

    public CreateAccountCommand(Bank bank, string accountNumber, decimal initialDeposit)
    {
        _bank = bank;
        _accountNumber = accountNumber;
        _initialDeposit = initialDeposit;
    }

    public void Execute()
    {
        _bank.CreateAccount(_accountNumber, _initialDeposit);
    }

    public void Signature()
    {
        Console.WriteLine($"Created Bank Account at {_accountNumber} with diposit {_initialDeposit}");
    }
}