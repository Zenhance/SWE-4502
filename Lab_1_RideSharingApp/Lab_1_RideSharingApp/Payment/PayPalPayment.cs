using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_1_RideSharingApp
{
    public class PayPalPayment : IPaymentMethod
    {
        public string Email { get; private set; }
        public int Otp { get; private set; }

        // Constructor
        public PayPalPayment(string email, int otp)
        {
            Email = email;
            Otp = otp;
        }

        // Implementing IPaymentMethod interface
        public void ProcessPayment(double amount)
        {
            Console.WriteLine($"Processing PayPal payment of {amount}.");
            Console.WriteLine($"Email: {Email}, OTP: {Otp}");
        }
    }
}
