using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Components
{
    public class TemperatureCommandHandler : VoiceCommandHandler
    {
        public override string HandleCommand(string command)
        {
            if (command.ToLower().Contains("temperature"))
            {
                // Process temperature command.
                return "Temperature command processed.";
            }
            return base.HandleCommand(command);
        }
    }
}
