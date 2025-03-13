using HomeAutomation.Core;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HomeAutomation.Core;

namespace HomeAutomation.Components
{
    public class VoiceCommandProcessor : IComponent
    {
        public List<string> CommandHistory { get; private set; } = new List<string>();

        public void OnStateChanged(EnvironmentalState state)
        {
            // In this simplified example, state changes do not affect command processing.
        }

        public string ProcessCommand(string command)
        {
         
            CommandHistory.Add(command);
            return command.ToUpper();
        }
    }
}
