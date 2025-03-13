using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace src
{
    public class EnergyConsumptionTracking : IObserver
    {
        private CoreComponent coreComponent;

        public EnergyConsumptionTracking(CoreComponent coreComponent)
        {
            this.coreComponent = coreComponent;
            coreComponent.RegisterObserver(this);
        }

        public void Update(string key, string value)
        {
            if (key == "energy")
            {
                LogEnergyUsage(value);
            }
        }

        public void LogEnergyUsage(string usage)
        {
            coreComponent.SetState("energyConsumption", usage);
        }

        public void CalculateStatistics()
        {
            Console.WriteLine("Calculating energy usage statistics...");
        }

        public void IdentifyUnusualPatterns()
        {
            Console.WriteLine("Identifying unusual consumption patterns...");
        }
    }
}
