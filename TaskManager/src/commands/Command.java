package commands;

import java.time.LocalDateTime;

public abstract class Command {
    protected String description;
    protected LocalDateTime timestamp;
    protected String type;

    public Command(String description, String type) {
        this.description = description;
        this.timestamp = LocalDateTime.now();
        this.type = type;
    }

    public abstract void execute();
    public abstract void undo();

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;



}
}