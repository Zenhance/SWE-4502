using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace taskManager
{
    public class CommandManager
    {
        Stack<Icommand> executeCommands = new Stack<Icommand>();
        Stack<Icommand> unDoneCommands = new Stack<Icommand>();

        public void Execute(Icommand command)
        {

        }

    }
}
