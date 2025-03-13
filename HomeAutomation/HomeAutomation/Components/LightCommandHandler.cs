using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Components
{
    public class LightCommandHandler : VoiceCommandHandler
    {
        public override string HandleCommand(string command)
        {
            if (command.ToLower().Contains("light"))
            {
               
                return "Light command processed.";
            }
            return base.HandleCommand(command);
        }
    }
}
