using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager_112
{
    public class NotificationService
    {
        public void Notify(string message)
        {
            Console.WriteLine($"Incoming notification: {message}");
        }
    }
}
