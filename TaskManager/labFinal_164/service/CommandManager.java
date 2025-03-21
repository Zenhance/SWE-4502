package labFinal_164.service;


import labFinal_164.command.ICommand;
import labFinal_164.repository.IssueRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommandManager implements  ISubject {
    private Stack<ICommand> undoStack = new Stack<>();
    private Stack<ICommand> redoStack = new Stack<>();

    private List<IObserver> observers = new ArrayList<>();
    private IssueRepository repository;

    public CommandManager(IssueRepository repository) { this.repository = repository; }
    public void executeCommand(ICommand command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
        notifyObservers(command);
    }
    public void undo() {
        if (!undoStack.isEmpty()) {
            ICommand command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }
    public void redo() {
        if (!redoStack.isEmpty()) {
            ICommand command = redoStack.pop();
            command.execute();
            undoStack.push(command);
            notifyObservers(command);
        }
    }


    @Override
    public void registerObserver(IObserver observer) { observers.add(observer); }
    @Override
    public void removeObserver(IObserver observer) { observers.remove(observer); }
    @Override
    public void notifyObservers(ICommand command) {
        for (IObserver observer : observers) {
            observer.update(command);
        }
    }







}
