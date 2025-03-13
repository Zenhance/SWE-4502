using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Components
{
    public class DefaultCommandHandler : VoiceCommandHandler
    {
        public override string HandleCommand(string command)
        {
     
            return "Default handler: Command not recognized.";
        }
    }
}
