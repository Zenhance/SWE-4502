using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_05_NotifiDapters
{
    // Email notification class
    public class EmailNotification : INotification
    {
        public void Send(string to, string message)
        {
            Console.WriteLine($"Sending Email to {to}: {message}");
            // Logic for sending email would go here
        }
    }
}
