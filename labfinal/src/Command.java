import java.time.LocalDateTime;

public abstract class Command {

    private String description;
    private LocalDateTime timestamp;
    private OperationType type;

    public Command(String description, OperationType type){
        this.description = description;
        this.type= type;
        timestamp= LocalDateTime.now();
    }
    public abstract void execute();
    public abstract void undo();

    public String getDescription(){
        return description;
    }

    public LocalDateTime getTimestamp(){
        return timestamp;
    }

    public OperationType getType() {
        return type;
    }
}
