using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class EnergyTracker : IObserver
    {
        public EnergyChain energychain;
        public EnergyTracker(EnergyChain chain)
        {
            energychain = chain;
        }
        public void Notify(EnvironmentalState state)
        {
            energychain.Manager(state);
        }
    }
}
