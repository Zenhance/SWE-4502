using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_1_RideSharingApp
{
    public class CreditCardPayment : IPaymentMethod
    {
        public int CardNumber { get; private set; }
        public string CardHolderName { get; private set; }

        // Constructor
        public CreditCardPayment(int cardNumber, string cardHolderName)
        {
            CardNumber = cardNumber;
            CardHolderName = cardHolderName;
        }

        // Implementing IPaymentMethod interface
        public void ProcessPayment(double amount)
        {
            Console.WriteLine($"Processing credit card payment of {amount}.");
            Console.WriteLine($"Card Number: {CardNumber}, Card Holder: {CardHolderName}");
        }
    }
}
