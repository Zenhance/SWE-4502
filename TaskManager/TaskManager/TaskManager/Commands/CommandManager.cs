using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager.Commands
{
        public class CommandManager
        {
            private readonly Stack<ICommand> _executedCommands;
            private readonly Stack<ICommand> _undoneCommands;
            private readonly List<CommandLog> _commandLogs;

            public CommandManager()
            {
                _executedCommands = new Stack<ICommand>();
                _undoneCommands = new Stack<ICommand>();
                _commandLogs = new List<CommandLog>();
            }

            public void ExecuteCommand(ICommand command)
            {
                command.Execute();
                _executedCommands.Push(command);
                _undoneCommands.Clear(); 
                LogCommand(command);
            }

            public void Undo()
            {
                if (_executedCommands.Count > 0)
                {
                    var command = _executedCommands.Pop();
                    command.Undo();
                    _undoneCommands.Push(command);
                }
            }

            public void Redo()
            {
                if (_undoneCommands.Count > 0)
                {
                    var command = _undoneCommands.Pop();
                    command.Execute();
                    _executedCommands.Push(command);
                }
            }

            private void LogCommand(ICommand command)
            {
                var log = new CommandLog
                {
                    Description = command.Description,
                    Timestamp = command.Timestamp,
                    Type = command.Type
                };
                _commandLogs.Add(log);
            }

            public IReadOnlyList<CommandLog> GetCommandLogs()
            {
                return _commandLogs.AsReadOnly();
            }
        }

        public class CommandLog
        {
            public string Description { get; set; }
            public DateTime Timestamp { get; set; }
            public CommandType Type { get; set; }
        }
}
