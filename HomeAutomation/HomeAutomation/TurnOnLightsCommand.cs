using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    
    public class TurnOnLightsCommand : IVoiceCommand
    {
        public void Execute()
        {
            Console.WriteLine("Executing Command: Turn on the lights");
        }
    }
}
