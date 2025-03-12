using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyHomeAutomation
{
    public class RemoteAccessApp : IObserver
    {
        private CoreSystem coreSystem;

        public RemoteAccessApp(CoreSystem coreSystem)
        {
            this.coreSystem = coreSystem;
            coreSystem.RegisterObserver(this);
        }

        public void Update(string key, string value)
        {
            if (key == "notification")
            {
                GenerateNotification(value);
            }
        }

        public void GenerateNotification(string message)
        {
            Console.WriteLine($"Notification: {message}");
        }

        public void DisplayState()
        {
            Console.WriteLine("Displaying current state...");
        }

        public void RemoteControl(string command)
        {
            coreSystem.SetState("notification", command);
        }
    }
}
