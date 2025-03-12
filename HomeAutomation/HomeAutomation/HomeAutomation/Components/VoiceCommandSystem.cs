using HomeAutomation.Core_Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Components
{
    public class VoiceCommandSystem : IObserver
    {
        public List<string> CommandHistory { get; private set; } = new List<string>();
        public string LastCommand { get; private set; } = "";

        public void Update (CentralState state)
        {
            if(!string.IsNullOrEmpty(state.VoiceCommand))
            {
                LastCommand = state.VoiceCommand;
                CommandHistory.Add(state.VoiceCommand);
                Console.WriteLine($"Voice Command Received: {state.VoiceCommand}");
            }
        }


    }
}
