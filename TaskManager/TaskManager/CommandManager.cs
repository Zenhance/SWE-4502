using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager
{
    public class CommandManager : ICommand
    {
        public List<ICommand> Commands = new List<ICommand>();

        public void Execute()
        {
            foreach (var command in Commands)
            {
                command.Execute();
            }
        }

        public void Undo()
        {
            for (int i = Commands.Count - 1; i >= 0; i--)
            {
                Commands[i].Undo();
            }
        }

        public String Description() 
        {
            return "Command Manager";
        }

    }
}
