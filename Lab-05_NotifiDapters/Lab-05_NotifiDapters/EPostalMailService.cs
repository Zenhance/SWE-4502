using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_05_NotifiDapters
{
    // Third-party e-Postal Mail system that has a different method signature
    public class EPostalMailService
    {
        public void SendPostalMail(string recipientName, string streetAddress, string city, string postalCode, string message)
        {
            Console.WriteLine($"Sending Postal Mail to {recipientName}, {streetAddress}, {city}, {postalCode}: {message}");
            // Logic for sending postal mail would go here
        }
    }

}
