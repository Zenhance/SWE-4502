using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class RemoteController : IRemoteController
    {
        public void DisplayCurrentState()
        {
            // Example current state of the home environment
            Console.WriteLine("Current Home State:");
            Console.WriteLine("Lights: ON");
            Console.WriteLine("Thermostat: 22°C");
            Console.WriteLine("Motion detected: No");
            Console.WriteLine("Power consumption: 350W");
        }

        public void GenerateNotifications(string message)
        {
            // Example notification system
            Console.WriteLine($"Notification: {message}");
        }

        public void ControlSystem(string command)
        {
            // Control home system via commands
            Console.WriteLine($"Executing system command: {command}");
            switch (command.ToLower())
            {
                case "turn on the lights":
                    Console.WriteLine("Lights turned on remotely.");
                    break;
                case "turn off the lights":
                    Console.WriteLine("Lights turned off remotely.");
                    break;
                case "set thermostat to 20 degrees":
                    Console.WriteLine("Thermostat set to 20°C remotely.");
                    break;
                default:
                    Console.WriteLine("Unknown command.");
                    break;
            }
        }
    }
}
