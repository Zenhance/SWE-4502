using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_1_RideSharingApp
{
    public class DigitalWalletPayment : IPaymentMethod
    {
        public string WalletId { get; private set; }
        public int Otp { get; private set; }

        // Constructor
        public DigitalWalletPayment(string walletId, int otp)
        {
            WalletId = walletId;
            Otp = otp;
        }

        // Implementing IPaymentMethod interface
        public void ProcessPayment(double amount)
        {
            Console.WriteLine($"Processing Digital Wallet payment of {amount}.");
            Console.WriteLine($"Wallet ID: {WalletId}, OTP: {Otp}");
        }
    }
}
