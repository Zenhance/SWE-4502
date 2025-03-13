using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace src
{
    public class RemoteAccessApp : IObserver
    {
        private CoreComponent coreComponent;

        public RemoteAccessApp(CoreComponent coreComponent)
        {
            this.coreComponent = coreComponent;
            coreComponent.RegisterObserver(this);
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
            coreComponent.SetState("notification", command);
        }
    }
}
