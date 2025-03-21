package labFinal_164.command;

public interface ICommand {
    void execute();
    void undo();
    String getType();
    String getDescription();

}
