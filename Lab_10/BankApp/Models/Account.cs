namespace BankApp.Models;

public class Account
{
    public string AccountNumber { get; set; }
    public decimal Balance { get; set; }
    public List<Transaction> Transactions { get; }

    public Account(string accountNumber, decimal initialDeposit)
    {
        this.AccountNumber = accountNumber;
        this.Balance = initialDeposit;
        Transactions = new List<Transaction>
        {
            new Transaction("Deposit", initialDeposit)
        };
    }

    public void Deposit(decimal amount)
    {
        
        Balance += amount;
        Transactions.Add(new Transaction("deposit",amount));
        Console.WriteLine($"Deposited {amount} into {AccountNumber}. New balance: {Balance}");
    }

    public void Withdraw(decimal amount)
    {
        if (amount < Balance)
        {
            Balance -= amount;
            Transactions.Add(new Transaction("Withdraw", amount));
            Console.WriteLine($"Withdrawn {amount} from {AccountNumber}. New balance {Balance}");
        }
        else
        {
            Console.WriteLine("Insufficient Funds");
        }
        
    }
}