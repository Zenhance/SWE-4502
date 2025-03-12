using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Componenets
{
    public class VoiceCommandSystem
    {
        private Dictionary<string, Action> commands = new();

        public VoiceCommandSystem()
        {
            commands["turn on lights"] = () => Console.WriteLine("Lights turned ON");
            commands["turn off lights"] = () => Console.WriteLine("Lights turned OFF");
            commands["increase temperature"] = () => Console.WriteLine("Temperature increased");
        }

        public void ProcessCommand(string command)
        {
            if (commands.ContainsKey(command))
            {
                commands[command].Invoke();
            }
            else
            {
                Console.WriteLine("Unknown command.");
            }
        }
    }

}
