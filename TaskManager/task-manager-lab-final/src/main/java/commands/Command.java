package commands;

import models.CommandType;

public abstract class Command {
    String commandEntry;
    CommandType commandType;
    abstract void execute();

    abstract void undo();

    Command(String issue, CommandType type){
        this.commandEntry = issue;
        this.commandType = type;
    }
    
}
