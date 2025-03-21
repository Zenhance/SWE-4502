import java.util.*;

public class CommandManager {
    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();
    private List<String> logs = new ArrayList<>();

    public void executeCommand(Command command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
        logs.add(command.getDescription() + " at " + command.getTimestamp());
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command cmd = undoStack.pop();
            cmd.undo();
            redoStack.push(cmd);
            logs.add("Undo: " + cmd.getDescription());
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command cmd = redoStack.pop();
            cmd.execute();
            undoStack.push(cmd);
            logs.add("Redo: " + cmd.getDescription());
        }
    }

    public List<String> getLogs() {
        return logs;
    }
}
