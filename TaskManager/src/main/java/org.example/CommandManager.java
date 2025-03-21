package org.example;

    import java.util.Stack;

    public class CommandManager {
        private Stack<Command> executedCommands = new Stack<>();
        private Stack<Command> undoneCommands = new Stack<>();

        public void executeCommand(Command command) {
            command.execute();
            executedCommands.push(command);
            undoneCommands.clear();
        }

        public void undoCommand() {
            if (!executedCommands.isEmpty()) {
                Command command = executedCommands.pop();
                command.undo();
                undoneCommands.push(command);
            }
        }

        public void redoCommand() {
            if (!undoneCommands.isEmpty()) {
                Command command = undoneCommands.pop();
                command.execute();
                executedCommands.push(command);
            }
        }
    }
