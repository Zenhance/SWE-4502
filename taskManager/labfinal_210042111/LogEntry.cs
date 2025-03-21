using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;

namespace labfinal_210042111
{
    public enum CommandType { create, update, delete }
    public class LogEntry
    {
        public string Description { get; set; }
        public DateTime timeStamp { get; set; }
        public CommandType Type { get; set; }

        public LogEntry(string description, DateTime timeStamp, CommandType type)
        {
            Description = description;
            this.timeStamp = timeStamp;
            Type = type;
        }



        
    }
}
