using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_05_NotifiDapters
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Create the notification instances
            INotification emailNotification = new EmailNotification();
            INotification smsNotification = new SMSNotification();

            // Use the third-party postal service via the adapter
            EPostalMailService postalService = new EPostalMailService();
            INotification postalMailNotification = new EPostalMailAdapter(postalService);

            // Send notifications
            emailNotification.Send("email@example.com", "Hello via Email!");
            smsNotification.Send("1234567890", "Hello via SMS!");
            postalMailNotification.Send("postal@example.com", "Hello via Postal Mail!");

            Console.ReadKey();
        }
    }
}
