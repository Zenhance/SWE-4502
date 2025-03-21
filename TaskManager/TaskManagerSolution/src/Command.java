import java.time.LocalDateTime;

public abstract class Command {
    private String description;
    private LocalDateTime timestamp;
    private CommandType type;

    public Command(String description, CommandType type) {
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

    public CommandType getType() {
        return type;
    }

}
