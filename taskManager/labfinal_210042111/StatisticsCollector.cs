using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace labfinal_210042111
{
    public class StatisticsCollector
    {
        public int CreateCommandCount { get; private set; }
        public int UpdateCommandCount { get; private set; }
        public int DeleteCommandCount { get; private set; }
        public int IssuesCreated { get; private set; }

        public void Increment(CommandType type)
        {
            switch (type)
            {
                case CommandType.create:
                    CreateCommandCount++;
                    break;
                case CommandType.update:
                    UpdateCommandCount++;
                    break;
                case CommandType.delete:
                    DeleteCommandCount++;
                    break;
            }
        }

        public void IncrementIssueCreated() => IssuesCreated++;

    }
}
