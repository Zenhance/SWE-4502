package subjects;

import commands.Command;
import models.CommandLog;
import observers.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommandManager implements Subject{
    private Stack<Command> executedCommands = new Stack<>();
    private Stack<Command> undoneCommands = new Stack<>();
    private List<CommandLog> commandLogs = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public void executeCommand(Command command) {
        command.execute();
        executedCommands.push(command);
        undoneCommands.clear(); // Clear redo stack on new command
        logCommand(command);
        notifyObservers(command);
    }

    public void undo() {
        if (!executedCommands.isEmpty()) {
            Command command = executedCommands.pop();
            command.undo();
            undoneCommands.push(command);
//            logUndo(command);
//            notifyObserversUndo(command);
        }
    }

    public void redo() {
        if (!undoneCommands.isEmpty()) {
            Command command = undoneCommands.pop();
            command.execute();
            executedCommands.push(command);
//            logRedo(command);
            notifyObservers(command);
        }
    }

    private void logCommand(Command command) {
        CommandLog log = new CommandLog(command.getDescription(), command.getTimestamp(), command.getType());
        commandLogs.add(log);
    }

    // Similar for logUndo and logRedo

    // Observer pattern methods
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers(Command command) {
        for (Observer observer : observers) {
            observer.update(command);
        }
    }

    // Similar for notifyObserversUndo

    // Methods to access logs
    public List<CommandLog> getLogs() {
        return new ArrayList<>(commandLogs);
    }

    @Override
    public void addObserver() {
        
    }

    @Override
    public void removeObserver() {

    }

    @Override
    public void notifyObserver() {

    }
}
