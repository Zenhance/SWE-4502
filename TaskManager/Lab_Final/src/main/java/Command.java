import java.time.LocalDateTime;

public abstract class Command {
    private String description;
    private CommandType type;

    public Command(String description, CommandType type) {
        this.description = description;
        this.type = type;
    }

    public abstract void execute();
    public abstract void undo();

    public String getDescription() {
        return description;
    }

    public CommandType getType() {
        return type;
    }

}
