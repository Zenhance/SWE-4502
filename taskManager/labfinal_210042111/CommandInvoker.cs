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
        public string undo()
        {
            return "success";
        }
        public string redo()
        {
            return "success";
           

        }
    }
}
