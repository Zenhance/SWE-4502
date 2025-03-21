package Lab_Final_210042150.Task_Management_System.Command;

import Lab_Final_210042150.Task_Management_System.Interfaces.Command;
import Lab_Final_210042150.Task_Management_System.Services.LoggingServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommandManager {
    private final Stack<Command> undoStack = new Stack<>();
    private final Stack<Command> redoStack = new Stack<>();
    private final LoggingServices loggingService;

    public CommandManager(LoggingServices loggingService) {
        this.loggingService = loggingService;
    }

    public void executeCommand(Command command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
        loggingService.logCommand(command);
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
            loggingService.logUndo(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
            loggingService.logRedo(command);
        }
    }

    public List<Command> getCommandHistory() {
        return new ArrayList<>(undoStack);
    }

    public boolean canUndo() {
        return !undoStack.isEmpty();
    }

    public boolean canRedo() {
        return !redoStack.isEmpty();
    }
}
