using src;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTest
{
    public class EnergyConsumptionTrackingTests
    {
        [Fact]
        public void TestLogEnergyUsage()
        {
            var coreComponent = new CoreComponent();
            var energyTracking = new EnergyConsumptionTracking(coreComponent);
            coreComponent.SetState("energy", "100 kWh");
            energyTracking.Update("energy", "100 kWh");
        }
    }
}
