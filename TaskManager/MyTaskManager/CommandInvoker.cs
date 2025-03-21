using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyTaskManager
{
    public class CommandInvoker
    {
        private readonly Stack<Command> undoStack;
        private readonly Stack<Command> redoStack;
        private readonly List<string> commandLogs;
        private readonly Dictionary<CommandType, int> commandCounts;

        public CommandInvoker()
        {
            undoStack = new Stack<Command>();
            redoStack = new Stack<Command>();
            commandLogs = new List<string>();
            commandCounts = new Dictionary<CommandType, int>
            {
                { CommandType.Create, 0 },
                { CommandType.Update, 0 },
                { CommandType.Delete, 0 }
            };
        }

        public void ExecuteCommand(Command command)
        {
            command.Execute();
            undoStack.Push(command);
            redoStack.Clear();

            string logEntry = $"Time: {command.Timestamp}, Command Type: {command.Type}, Description: {command.Description}";
            commandLogs.Add(logEntry);

            commandCounts[command.Type]++;

        }

        public void Undo()
        {
            if (undoStack.Count > 0)
            {
                Command command = undoStack.Pop();
                command.Undo();
                redoStack.Push(command);

                string logEntry = $"Time: {DateTime.Now}, Command Type: Undo, Description: {command.Description}";
                commandLogs.Add(logEntry);

            }
        }

        public void Redo()
        {
            if (redoStack.Count > 0)
            {
                Command command = redoStack.Pop();
                command.Execute();
                undoStack.Push(command);

                string logEntry = $"Time: {DateTime.Now}, Command Type: Redo, Description: {command.Description}";
                commandLogs.Add(logEntry);

            }
        }

        public int GetCommandStats(CommandType commandType)
        {
            return commandCounts[commandType];
        }

        public List<string> GetCommandLogs()
        {
            return commandLogs;
        }
    }
}