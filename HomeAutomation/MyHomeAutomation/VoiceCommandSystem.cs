using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyHomeAutomation
{
    public class VoiceCommandSystem : IObserver
    {
        private CoreSystem coreSystem;

        public VoiceCommandSystem(CoreSystem coreSystem)
        {
            this.coreSystem = coreSystem;
            coreSystem.RegisterObserver(this);
        }

        public void Update(string key, string value)
        {
            if (key == "command")
            {
                ProcessCommand(value);
            }
        }

        public void ProcessCommand(string command)
        {
            Console.WriteLine($"Processing command: {command}");
        }

        public void MaintainCommandHistory()
        {
            Console.WriteLine("Maintaining command history...");
        }

        public void TranslateCommand(string command)
        {
            coreSystem.SetState("command", command);
        }
    }
}
