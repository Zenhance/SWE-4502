using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace labfinal_210042111
{
    public class CommandInvoker
    {
        private Stack<ICommand> commandStack = new Stack<ICommand>();
        private Stack<ICommand> undoStack = new Stack<ICommand>();

        public void executeCommand(ICommand command)
        {
            command.Execute();
            commandStack.Push(command);
            undoStack.Clear();
        }
        public void undo()
        {
            if (!commandStack.Any())
            {
                ICommand command = commandStack.Pop();
                command.undo();
                undoStack.Push(command);
            }
        }
        public void redo()
        {
            if (!undoStack.Any())
            {
                ICommand command = undoStack.Pop();
                command.Execute();
                commandStack.Push(command);
            }

        }
    }
}
