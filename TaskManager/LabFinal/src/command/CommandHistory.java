package command;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CommandHistory {
    private final LinkedList<Command> history = new LinkedList<>();
    private final LinkedList<Command> redoStack = new LinkedList<>();

    public void push(Command command) {
        history.push(command);
        redoStack.clear();
    }

    public Command pop() {
        if (!history.isEmpty()) {
            Command command = history.pop();
            redoStack.push(command);
            return command;
        }
        return null;
    }
    public Command redoCommand() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            history.push(command);
            return command;
        }
        return null;
    }

    public boolean canUndo() {
        return !history.isEmpty();
    }

    public boolean canRedo() {
        return !redoStack.isEmpty();
    }

    public List<Command> getExecutedCommands() {
        return new ArrayList<>(history);
    }

    public void clearRedoStackOnNewCommand() {
        redoStack.clear();
    }
}


