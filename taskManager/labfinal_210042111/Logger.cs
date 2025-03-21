using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace labfinal_210042111
{
    public class Logger
    {
        private List<LogEntry> logEntries=new List<LogEntry>();

        public void Log(string Description, DateTime timeStamp, string type)
        {
           logEntries.Add(new LogEntry(Description, timeStamp, type ));

        }
    }
}
