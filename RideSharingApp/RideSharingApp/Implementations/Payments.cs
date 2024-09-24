using RideSharingApp.Behaviours;

namespace RideSharingApp.Implementations;


public class CreditCardPayment : IPayment
{
    public void ProcessPayment(double amount)
    {
        Console.WriteLine($"Processing credit card payment of ${amount}");
    }
}

public class PayPalPayment : IPayment
{
    public void ProcessPayment(double amount)
    {
        Console.WriteLine($"Processing PayPal payment of ${amount}");
    }
}

public class DigitalWalletPayment : IPayment
{
    public void ProcessPayment(double amount)
    {
        Console.WriteLine($"Processing digital wallet payment of ${amount}");
    }
}
