package command;

public interface Command {
    void execute();
    void undo();
    String getDescription();
    String getTimestamp();
    CommandType getType();
}