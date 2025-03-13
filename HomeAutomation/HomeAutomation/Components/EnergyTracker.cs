using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HomeAutomation.Core;

namespace HomeAutomation.Components
{
    public class EnergyTracker
    {
        public double CurrentPowerUsage { get; private set; }
        public double TotalEnergyConsumed { get; private set; }

      
    }
}
