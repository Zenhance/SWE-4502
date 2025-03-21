namespace LabFinal;

    public class CommandManager
    {
        private readonly Stack<ICommand> _executedCommands = new Stack<ICommand>();
        private readonly Stack<ICommand> _undoneCommands = new Stack<ICommand>();

        public void ExecuteCommand(ICommand command)
        {
            command.Execute();
            _executedCommands.Push(command);
            _undoneCommands.Clear();
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

        public IEnumerable<CommandLog> GetCommandHistory()
        {
            return _executedCommands.Select(c => c.GetLog());
        }
    }

