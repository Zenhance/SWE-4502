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
        public EnergyTracker()
        {
            energychain = new MotionEnergy();
        }
        public void Notify(HomeEnvironment env)
        {
            energychain.Manager(env);
        }
    }
}
