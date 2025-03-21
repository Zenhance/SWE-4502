using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager
{
    public class NotificationService
    {
        public void Notify(string message)
        {
            Console.WriteLine("Notification sent: " + message);
        }
    }
}
