using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class MotionAnalyzer
    {
        private readonly List<Tuple<DateTime, string>> _motionLogs = new List<Tuple<DateTime, string>>();

        public void LogMotion(string location)
        {
            _motionLogs.Add(new Tuple<DateTime, string>(DateTime.Now, location));
            Console.WriteLine($"Logged motion at {location} on {DateTime.Now}");
        }

        public void AnalyzePatterns()
        {
            if (_motionLogs.Count == 0)
            {
                Console.WriteLine("No motion data available for analysis.");
                return;
            }

            var groupedByLocation = _motionLogs.GroupBy(entry => entry.Item2);
            Console.WriteLine("Motion Analysis Report:");
            foreach (var group in groupedByLocation)
            {
                Console.WriteLine($"Location: {group.Key}, Motion occurrences: {group.Count()}");
            }
        }
    }
}
