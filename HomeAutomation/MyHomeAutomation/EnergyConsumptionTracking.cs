using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyHomeAutomation
{
    public class EnergyConsumptionTracking : IObserver
    {
        private CoreSystem coreSystem;

        public EnergyConsumptionTracking(CoreSystem coreSystem)
        {
            this.coreSystem = coreSystem;
            coreSystem.RegisterObserver(this);
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
            Console.WriteLine($"Energy usage: {usage}");
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
