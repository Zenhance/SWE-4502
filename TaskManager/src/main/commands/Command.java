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
    private String description;
    private LocalDate timeStamp;
    private Type type;

    public Command(String _description, Type _type) {
        this.description = _description,
        this.timeStamp = LocalDate.now();
        this.type = _type;
    }

    public abstract void execute();
    public abstract void undo();
}
