using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class CoolCommand:ITemp
    {
        public void Do()
        {
            Console.WriteLine("Activating Cooling...");
        }
    }
}
