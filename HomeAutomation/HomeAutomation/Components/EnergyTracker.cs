using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HomeAutomation.Core;

namespace HomeAutomation.Components
{
    public class EnergyTracker : IComponent 
    {
        public double CurrentPowerUsage { get; private set; }
        public double TotalEnergyConsumed { get; private set; }
        public void OnStateChanged(EnvironmentalState state)
        {
           
            CurrentPowerUsage = state.AmbientLight * 0.7; //dummy calc
            TotalEnergyConsumed += CurrentPowerUsage;
        }

    }
}
