using HomeAutomation.Components;
using HomeAutomation.Core;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomationTest
{
    public class EnergyTrackerTests
    {
        [Fact]
        public void OnStateChanged_UpdatesPowerUsageAndTotalEnergy()
        {
            var tracker = new EnergyTracker();
            var state = new EnvironmentalState { AmbientLight = 60 };

            tracker.OnStateChanged(state);
            double expectedUsage = 60 * 0.7;

            Assert.Equal(expectedUsage, tracker.CurrentPowerUsage);
            Assert.Equal(expectedUsage, tracker.TotalEnergyConsumed);

         
            tracker.OnStateChanged(state);
            Assert.Equal(expectedUsage, tracker.CurrentPowerUsage);
            Assert.Equal(expectedUsage * 2, tracker.TotalEnergyConsumed);
        }
    }
}
