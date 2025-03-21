package Lab_Final_210042150.Task_Management_System.Interfaces;

import java.time.LocalDateTime;
import Lab_Final_210042150.Task_Management_System.Enums.commandType;

public interface Command {
    void execute();
    void undo();
    String getDescription();
    LocalDateTime getTimestamp();
    commandType getType();
}
