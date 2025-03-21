using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager_112
{
    public class CommandLogger
    {
        private List<string> logs = new List<string>();

        public void AddLogs(string message)
        {
            logs.Add(message);
            Console.WriteLine("Logged message: " + message);
        }

        public void DisplayLogs()
        {
            foreach (var log in logs)
            {
                Console.WriteLine("Messages: " + log);
            }
        }
    }
}
