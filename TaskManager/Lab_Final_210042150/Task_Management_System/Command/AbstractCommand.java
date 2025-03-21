package Lab_Final_210042150.Task_Management_System.Command;

import Lab_Final_210042150.Task_Management_System.Enums.commandType;
import Lab_Final_210042150.Task_Management_System.Interfaces.Command;

import java.time.LocalDateTime;

public abstract class AbstractCommand implements Command {
    private final String description;
    private final LocalDateTime timestamp;
    private final commandType type;

    protected AbstractCommand(String description, commandType type) {
        this.description = description;
        this.timestamp = LocalDateTime.now();
        this.type = type;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public commandType getType() {
        return type;
    }

}
