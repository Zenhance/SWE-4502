using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace src
{
    public class VoiceCommandSystem : IObserver
    {
        private CoreComponent coreComponent;

        public VoiceCommandSystem(CoreComponent coreComponent)
        {
            this.coreComponent = coreComponent;
            coreComponent.RegisterObserver(this);
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
            coreComponent.SetState("command", command);
        }
    }
}
