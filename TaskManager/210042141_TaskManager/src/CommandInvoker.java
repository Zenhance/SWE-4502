import java.util.Stack;

public class CommandInvoker {
    private Stack<Command> commandHistory = new Stack<>();
    private Stack<Command> redoHistory = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
        redoHistory.clear();
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            Command command = commandHistory.pop();
            command.undo();
            redoHistory.push(command);
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            Command command = redoHistory.pop();
            command.execute();
            commandHistory.push(command);
        }
    }
}
