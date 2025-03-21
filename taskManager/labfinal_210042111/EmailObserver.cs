using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace labfinal_210042111
{
    public class ConsoleObserver:IObserver
    {
        public List<string> notifications = new List<string>();

        public void Update(string message)
        {
            Console.WriteLine("Observer Received: " + message);
            notifications.Add(message);
        }


    }
}
