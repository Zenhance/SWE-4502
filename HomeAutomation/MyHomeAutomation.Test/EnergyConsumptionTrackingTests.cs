using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyHomeAutomation.Test
{
    public class EnergyConsumptionTrackingTests
    {
        [Fact]
        public void TestLogEnergyUsage()
        {
            var coreSystem = new CoreSystem();
            var energyTracking = new EnergyConsumptionTracking(coreSystem);
            coreSystem.SetState("energy", "100 kWh");
            energyTracking.Update("energy", "100 kWh");
        }
    }
}
