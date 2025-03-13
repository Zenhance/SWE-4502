using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class HeatCommand : ITemp
    {
        public void Do()
        {
            Console.WriteLine("Activating heating...");

        }
    }
}
