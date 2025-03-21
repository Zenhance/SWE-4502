package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommandManager {
    private static CommandManager instance;
    private final Stack<Command> undoStack;
    private final Stack<Command> redoStack;
    private final List<CommandLog> commandLogs;
    private final List<CommandObserver> observers;
    private final CommandStatistics statistics;

    private CommandManager() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
        commandLogs = new ArrayList<>();
        observers = new ArrayList<>();
        statistics = new CommandStatistics();
    }

    public static synchronized CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }

    public void executeCommand(Command command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear(); // Clear redo stack when a new command is executed
        
        // Log the command
        CommandLog log = new CommandLog(command.getDescription(), command.getTimestamp(), command.getType());
        commandLogs.add(log);
        
        // Update statistics
        statistics.incrementCommandCount(command.getType());
        
        // Notify observers
        notifyObservers(command);
    }

    public void undoCommand() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
            
            // Log the undo operation
            CommandLog log = new CommandLog("Undone: " + command.getDescription(), 
                    command.getTimestamp(), command.getType());
            commandLogs.add(log);
            
            // Notify observers
            notifyObservers(command);
        }
    }

    public void redoCommand() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
            
            // Log the redo operation
            CommandLog log = new CommandLog("Redone: " + command.getDescription(), 
                    command.getTimestamp(), command.getType());
            commandLogs.add(log);
            
            // Notify observers
            notifyObservers(command);
        }
    }

    public boolean canUndo() {
        return !undoStack.isEmpty();
    }

    public boolean canRedo() {
        return !redoStack.isEmpty();
    }

    public List<CommandLog> getCommandLogs() {
        return new ArrayList<>(commandLogs);
    }

    public void addObserver(CommandObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(CommandObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(Command command) {
        for (CommandObserver observer : observers) {
            observer.update(command);
        }
    }

    public CommandStatistics getStatistics() {
        return statistics;
    }
}