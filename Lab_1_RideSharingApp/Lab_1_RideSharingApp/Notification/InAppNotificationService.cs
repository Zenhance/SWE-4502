using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_1_RideSharingApp
{
    public class InAppNotificationService : INotificationService
    {
        public void SendNotification(string message)
        {
            Console.WriteLine($"In-App Notification: {message}"); 
        }
    }
}
