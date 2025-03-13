using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class LightOn:IVoice
    {
        public void Execute()
        {
            Console.WriteLine("Voice Command: Turning the light on.");
        }
    }
}
