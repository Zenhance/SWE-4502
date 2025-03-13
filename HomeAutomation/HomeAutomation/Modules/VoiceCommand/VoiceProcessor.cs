using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class VoiceProcessor : IVoiceProcessor
    {
        private string _lastCommand;
        private readonly List<string> _commandHistory = new List<string>();

        public void ProcessCommand(string command)
        {
            _lastCommand = command;
            _commandHistory.Add(command);
            Console.WriteLine($"Processing voice command: {command}");

            // Simulated command execution logic
            switch (command.ToLower())
            {
                case "turn on the lights":
                    Console.WriteLine("Executing: Turning on the lights.");
                    break;
                case "turn off the lights":
                    Console.WriteLine("Executing: Turning off the lights.");
                    break;
                case "set thermostat to 22 degrees":
                    Console.WriteLine("Executing: Setting thermostat to 22°C.");
                    break;
                default:
                    Console.WriteLine("Command not recognized.");
                    break;
            }
        }

        public string GetLastCommand()
        {
            return _lastCommand ?? "No command processed yet.";
        }

        public void ShowCommandHistory()
        {
            Console.WriteLine("Voice Command History:");
            foreach (var command in _commandHistory)
            {
                Console.WriteLine($"- {command}");
            }
        }
    }
}
