package command;
import java.time.LocalDateTime;

public abstract class AbstractCommand implements Command {
    private final LocalDateTime timestamp;
    private final CommandType type;

    public AbstractCommand(CommandType type) {
        this.timestamp = LocalDateTime.now();
        this.type = type;
    }
    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    @Override
    public CommandType getType() {
        return type;
    }

}

