using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager.Commands
{
        public interface ICommand
        {
            void Execute();
            void Undo();
            string Description { get; }
            DateTime Timestamp { get; }
            CommandType Type { get; }
        }
}
