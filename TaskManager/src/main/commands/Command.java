package main.commands;

import java.time.LocalDate;

import main.core.Issue;
import main.interfaces.IOperation;

enum Type {
    Create,
    Update,
    Delete
}

public abstract class Command implements IOperation{
    private Issue issue;
    private String description;
    private LocalDate timeStamp;
    private Type type;

    public Command() {
        
    }

    public abstract void execute();
    public abstract void undo();
}
