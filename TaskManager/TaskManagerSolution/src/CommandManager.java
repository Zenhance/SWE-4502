import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommandManager {
    private final Stack<Command> undoStack= new Stack<>();
    private final Stack<Command> redoStack = new Stack<>();

    private final List<Command> commandHistory = new ArrayList<>();

    public void executeCommand(Command command) {
        command.execute();
        undoStack.push(command);
        commandHistory.add(command);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }

    public List<Command> getCommandHistory() {
        return new ArrayList<>(commandHistory);
    }

    public boolean canUndo() {
        return !undoStack.isEmpty();
    }

    public boolean canRedo() {
        return !redoStack.isEmpty();
    }




}
