using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_05_NotifiDapters
{
    // SMS notification class
    public class SMSNotification : INotification
    {
        public void Send(string to, string message)
        {
            Console.WriteLine($"Sending SMS to {to}: {message}");
            // Logic for sending SMS would go here
        }
    }
}
