import java.util.Stack;

class CommandManager {
    private final Stack<ICommand> executedCommands = new Stack<>();
    private final Stack<ICommand> undoneCommands = new Stack<>();

    public void executeCommand(ICommand command) {
        command.execute();
        executedCommands.push(command);
        undoneCommands.clear();
    }

    public void undo() {
        if (!executedCommands.isEmpty()) {
            ICommand command = executedCommands.pop();
            command.undo();
            undoneCommands.push(command);
        } else {
            System.out.println("Nothing to undo!");
        }
    }

    public void redo() {
        if (!undoneCommands.isEmpty()) {
            ICommand command = undoneCommands.pop();
            command.execute();
            executedCommands.push(command);
        } else {
            System.out.println("Nothing to redo!");
        }
    }
}
