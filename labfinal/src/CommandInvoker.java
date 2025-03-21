import java.util.Stack;

public class CommandInvoker {
    private Stack<Command> undoStack= new Stack<>();
    private Stack<Command> redoStack = new Stack<>();


    public void executeCommand(Command command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

    public void undoCommand() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

}
