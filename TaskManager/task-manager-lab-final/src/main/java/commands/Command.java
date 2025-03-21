package commands;

import models.CommandType;

import java.security.Timestamp;

public abstract class Command {
    String commandEntry;
    String description;
    CommandType commandType;
    protected Timestamp timestamp;
    abstract public void execute();

    abstract public void undo();

    public Command(String issue, CommandType type){
        this.commandEntry = issue;
        this.commandType = type;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

    public CommandType getType() {
        return commandType;
    }
    
}
