import java.util.Stack;

public class CommandManager {
    private Command command;

    public Stack<Command> executedCommands;
    public Command UndoedCommand;

    public void setCommand(Command command) {
        this.command = command;
    }

    public Issue executeCommand(){
        executedCommands.push(command);
        return command.execute();
    }

    public Issue undoCommand(){
        UndoedCommand = command;
        return command.undo();
    }
}