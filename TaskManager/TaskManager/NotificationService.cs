using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager
{
    class NotificationService :IObserver
    {
        public void Notify()
        {
            Console.WriteLine("Email notification sent");
        }
    }
}
