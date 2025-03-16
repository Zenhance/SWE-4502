using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class EnergyMonitor : IEnergyMonitor
    {
        private readonly List<double> _powerUsageHistory = new List<double>();

        public void RecordPowerUsage(double watts)
        {
            _powerUsageHistory.Add(watts);
            Console.WriteLine($"Power usage recorded: {watts}W");
        }

        public double GetTotalConsumption()
        {
            return _powerUsageHistory.Sum();
        }

        public void AnalyzeUsagePatterns()
        {
            if (_powerUsageHistory.Count == 0)
            {
                Console.WriteLine("No data available for analysis.");
                return;
            }

            double averageUsage = _powerUsageHistory.Average();
            double peakUsage = _powerUsageHistory.Max();

            Console.WriteLine($"Average Power Usage: {averageUsage}W");
            Console.WriteLine($"Peak Power Usage: {peakUsage}W");
        }
    }
}
