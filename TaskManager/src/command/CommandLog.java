package command;

public class CommandLog {
    private final String description;
    private final String timestamp;
    private final CommandType type;



    public CommandLog(String description, String timestamp, CommandType type) {
        this.description = description;
        this.timestamp = timestamp;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public String getTimestamp() {
        return timestamp;
    }



    public CommandType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + description + " (" + type + ")";
    }
}