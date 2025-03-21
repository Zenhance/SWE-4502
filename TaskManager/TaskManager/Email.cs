using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager
{
    class Email :INotification
    {
        public void NotifyUser()
        {
            Console.WriteLine("Email notification sent");
        }
    }
}
