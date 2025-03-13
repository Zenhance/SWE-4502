using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xunit;
using HomeAutomation.Components;
using HomeAutomation.Core_Model;
using System.Collections.Generic;


namespace TestProject1
{
    public class TestEnergyConsumption
    {
        [Fact]
        public void Test_EnergyConsumption_InitialUsage()
        {
            EnergyConsumtion energyMonitor = new EnergyConsumtion();
            CentralState state = new CentralState { EnergyUsage = 10.0 };

            energyMonitor.Update(state);

            Assert.Single(energyMonitor.GetUsageHistory());
            Assert.Equal(10.0, energyMonitor.GetAverageUsuage());
        }

        [Fact]
        public void Test_EnergyConsumption_AverageCalculation()
        {
            EnergyConsumtion energyMonitor = new EnergyConsumtion();
            energyMonitor.TrackUsagesStatistics(5.0);
            energyMonitor.TrackUsagesStatistics(15.0);
            energyMonitor.TrackUsagesStatistics(25.0);

            Assert.Equal(15.0, energyMonitor.GetAverageUsuage());
        }

        [Fact]
        public void Test_EnergyConsumption_UnusualHighUsage()
        {
            EnergyConsumtion energyMonitor = new EnergyConsumtion();
            energyMonitor.TrackUsagesStatistics(10.0);
            energyMonitor.TrackUsagesStatistics(12.0);
            energyMonitor.TrackUsagesStatistics(50.0);

            List<double> history = energyMonitor.GetUsageHistory();
            Assert.Contains(50.0, history);
        }
    }
}
