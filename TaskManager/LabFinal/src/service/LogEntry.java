package service;
import java.time.LocalDateTime;

public class LogEntry
{
    private final LocalDateTime timestamp;
    private final String description;
    private final command.CommandType type;

    public LogEntry(LocalDateTime timestamp, String description, command.CommandType type)
    {
        this.timestamp = timestamp;
        this.description = description;
        this.type = type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

    public command.CommandType getType() {
        return type;
    }
}
