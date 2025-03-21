using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager_112
{
    public class CommandInvoker
    {
        private Stack<ICommand> commandHistory = new Stack<ICommand>();
        private Stack<ICommand> undoneCommands = new Stack<ICommand>();
        public void ExecuteCommand(ICommand command)
        {
            command.Execute();
            commandHistory.Push(command);
            undoneCommands.Clear(); 
        }
        public void Undo()
        {
            if (commandHistory.Count > 0)
            {
                ICommand command = commandHistory.Pop();
                command.Undo();
                undoneCommands.Push(command);
            }
        }
        public void Redo()
        {
            if (undoneCommands.Count > 0)
            {
                ICommand command = undoneCommands.Pop();
                command.Execute();
                commandHistory.Push(command);
            }
        }
    }
}
