
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class MotionAnalyzer
    {
        private readonly List<(DateTime Timestamp, string Location)> _motionLogs = new();

        public void LogMotion(string location)
        {
            _motionLogs.Add((DateTime.Now, location));
            Console.WriteLine($"Logged motion at {location} on {DateTime.Now}");
        }

        public void AnalyzePatterns()
        {
            if (_motionLogs.Count == 0)
            {
                Console.WriteLine("No motion data available for analysis.");
                return;
            }

            var groupedByLocation = _motionLogs.GroupBy(entry => entry.Location);
            Console.WriteLine("Motion Analysis Report:");
            foreach (var group in groupedByLocation)
            {
                Console.WriteLine($"Location: {group.Key}, Motion occurrences: {group.Count()}");
            }
        }
    }
}
