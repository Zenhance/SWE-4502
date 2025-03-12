using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public abstract class EnergyChain
    {
        protected EnergyChain chain;
        public void SetEnergyChain(EnergyChain energychain)
        {
            chain = energychain;
        }
        public abstract void Manager(HomeEnvironment env);
    }
}
