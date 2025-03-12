using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
   
    public class DefaultLightStrategy : ILightStrategy
    {
        public void AdjustLighting(int ambientLightLevel, bool isOccupied)
        {
            string lightStatus = isOccupied ? "On" : "Off";
            Console.WriteLine($"Default Strategy: Lights {lightStatus}");
        }
    }
}
