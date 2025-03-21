import java.time.LocalDateTime;

public interface Command {
    void execute();
    void undo();

}



