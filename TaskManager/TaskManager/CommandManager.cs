using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager
{
    public class CommandManager
    {
        private Stack<ICommand> executedCommands = new Stack<ICommand>();
        private Stack<ICommand> undoneCommands = new Stack<ICommand>();

        public void ExecuteCommand(ICommand command)
        {
            command.Execute();
            executedCommands.Push(command);
            undoneCommands.Clear();  // Prevent redo after a new command
        }

        public void Undo()
        {
            if (executedCommands.Count > 0)
            {
                ICommand lastCommand = executedCommands.Pop();
                lastCommand.Undo();
                undoneCommands.Push(lastCommand);
            }
        }

        public void Redo()
        {
            if (undoneCommands.Count > 0)
            {
                ICommand redoCommand = undoneCommands.Pop();
                redoCommand.Execute();
                executedCommands.Push(redoCommand);
            }
        }
    }
}
