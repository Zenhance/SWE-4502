using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_1_RideSharingApp
{
    public class PaymentService
    {
        // Method to retrieve the payment method selected by the user
        public IPaymentMethod GetPaymentMethod()
        {
            Console.WriteLine("Select Payment Method:");
            Console.WriteLine("1. Credit Card");
            Console.WriteLine("2. PayPal");
            Console.WriteLine("3. Digital Wallet");

            string choice = GetInput("Enter your choice: ");

            if (choice == "1")
            {
                return GetCreditCardPayment();
            }
            else if (choice == "2")
            {
                return GetPayPalPayment();
            }
            else if (choice == "3")
            {
                return GetDigitalWalletPayment();
            }
            else
            {
                return HandleInvalidChoice();
            }
        }

        // Validate the payment based on the fare amount
        public void ValidatePayment(double fare)
        {
            double amountPaid;

            while (true)
            {
                amountPaid = GetPaymentAmount();

                if (amountPaid < fare)
                {
                    Console.WriteLine("Payment failed: Insufficient amount. Please pay the required fare.");
                }
                else if (amountPaid > fare)
                {
                    double extraAmount = amountPaid - fare;
                    Console.WriteLine($"Payment successful! You overpaid by {extraAmount}. Returning extra amount...");
                    break;
                }
                else
                {
                    Console.WriteLine("Payment successful! You paid the correct amount.");
                    break;
                }
            }
        }

        // Helper method to get credit card payment details
        private IPaymentMethod GetCreditCardPayment()
        {
            int cardNumber = GetIntInput("Enter Card Number: ");
            string cardHolderName = GetInput("Enter Card Holder Name: ");
            return new CreditCardPayment(cardNumber, cardHolderName);
        }

        // Helper method to get PayPal payment details
        private IPaymentMethod GetPayPalPayment()
        {
            string email = GetInput("Enter PayPal Email: ");
            int otp = GetIntInput("Enter OTP: ");
            return new PayPalPayment(email, otp);
        }

        // Helper method to get digital wallet payment details
        private IPaymentMethod GetDigitalWalletPayment()
        {
            string walletId = GetInput("Enter Wallet ID: ");
            int otp = GetIntInput("Enter OTP: ");
            return new DigitalWalletPayment(walletId, otp);
        }

        // Handle invalid payment method choice
        private IPaymentMethod HandleInvalidChoice()
        {
            Console.WriteLine("Invalid payment method selected. Please choose again.");
            return GetPaymentMethod();
        }

        // Helper method to get payment amount from user
        private double GetPaymentAmount()
        {
            double amount;
            while (true)
            {
                try
                {
                    amount = double.Parse(GetInput("\nHow much did you pay? "));
                    if (amount < 0)
                    {
                        Console.WriteLine("Amount cannot be negative. Please enter a valid amount.");
                    }
                    else
                    {
                        return amount;
                    }
                }
                catch (FormatException)
                {
                    Console.WriteLine("Invalid input. Please enter a numeric value.");
                }
            }
        }

        // Helper method to get integer input
        private int GetIntInput(string prompt)
        {
            int result;
            while (true)
            {
                try
                {
                    result = int.Parse(GetInput(prompt));
                    return result;
                }
                catch (FormatException)
                {
                    Console.WriteLine("Invalid input. Please enter a numeric value.");
                }
            }
        }

        // Helper method to get string input from the user
        private string GetInput(string prompt)
        {
            Console.Write(prompt);
            return Console.ReadLine();
        }
    }

}
