using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyTaskManager
{
    public abstract class Command
    {
        public string Description { get; set; }
        public DateTime Timestamp { get; set; }
        public CommandType Type { get; set; }

        public Command()
        {
            Timestamp = DateTime.Now;
        }

        public abstract void Execute();
        public abstract void Undo();
    }
}
