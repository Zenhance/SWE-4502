using BankApp.Models;

namespace BankApp.App;

public class Bank
{
    private Dictionary<string, Account> _accounts = new();
    
    public void CreateAccount(string accountNumber, decimal initialDeposit)
    {
        if (!_accounts.ContainsKey(accountNumber))
        {
            _accounts[accountNumber] = new Account(accountNumber, initialDeposit);
            Console.WriteLine($"Account {accountNumber} created with balance: {initialDeposit}");
        }
        else
        {
            Console.WriteLine("Account already exists!");
        }
    }
    
    public void Deposit(string accountNumber, decimal amount)
    {
        if (_accounts.ContainsKey(accountNumber))
        {
            _accounts[accountNumber].Deposit(amount);
        }
        else
        {
            Console.WriteLine("Account not found!");
        }
    }

    public void Withdraw(string accountNumber, decimal amount)
    {
        if (_accounts.ContainsKey(accountNumber))
        {
            _accounts[accountNumber].Withdraw(amount);
        }
        else
        {
            Console.WriteLine("Account not found!");
        }
    }

    public void ShowBalance(string accountNumber)
    {
        if (_accounts.ContainsKey(accountNumber))
        {
            Console.WriteLine($"Balance for account {accountNumber}: {_accounts[accountNumber].Balance}");
        }
        else
        {
            Console.WriteLine("Account not found!");
        }
    }

    public void ShowTransactionHistory(string accountNumber)
    {
        if (_accounts.ContainsKey(accountNumber))
        {
            Console.WriteLine($"\nTransaction history for {accountNumber}:");
            foreach (var transaction in _accounts[accountNumber].Transactions)
            {
                Console.WriteLine($"{transaction.Date}: {transaction.Type} - {transaction.Amount}");
            }
        }
        else
        {
            Console.WriteLine("Account not found!");
        }
    }
}