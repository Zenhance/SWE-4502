using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HomeAutomation.Core;

namespace HomeAutomation.Componenets
{
    public class EnergyTracker : IEnvironmentObserver
    {
        private double lastPowerUsage = 0.0;

        public void OnEnvironmentStateChanged(EnvironmentState state)
        {
            if (state.PowerUsage > lastPowerUsage + 50) // Arbitrary anomaly detection
            {
                Console.WriteLine("Warning: Unusual power consumption detected!");
            }

            lastPowerUsage = state.PowerUsage;
        }
    }

}
