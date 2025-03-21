using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System;
using System.Collections.Generic;
using TaskManager.Commands;
using System.Threading.Tasks;

namespace TaskManager.Services
    {
        public class StatisticsService
        {
            private readonly Dictionary<CommandType, int> _commandTypeCount;
            private int _totalIssuesCreated;

            public StatisticsService()
            {
                _commandTypeCount = new Dictionary<CommandType, int>();
                foreach (CommandType type in Enum.GetValues(typeof(CommandType)))
                {
                    _commandTypeCount[type] = 0;
                }
            }

            public void TrackCommand(CommandType type)
            {
                _commandTypeCount[type]++;
                if (type == CommandType.Create)
                {
                    _totalIssuesCreated++;
                }
            }

            public Dictionary<CommandType, int> GetCommandStatistics()
            {
                return new Dictionary<CommandType, int>(_commandTypeCount);
            }

            public int GetTotalIssuesCreated()
            {
                return _totalIssuesCreated;
            }

            public void PrintStatistics()
            {
                Console.WriteLine("\nCommand Statistics:");
                foreach (var stat in _commandTypeCount)
                {
                    Console.WriteLine($"{stat.Key}: {stat.Value} times");
                }
                Console.WriteLine($"\nTotal Issues Created: {_totalIssuesCreated}");
            }
        }
}