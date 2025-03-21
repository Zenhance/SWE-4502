import java.util.Stack;

public class CommandManager {
    private Stack<Command> history = new Stack<>();
    private Stack<Command> undone = new Stack<>();

    public void executeCommand(Command cmd) {
        cmd.execute();
        history.push(cmd);
        undone.clear();
    }

    public void undo() {
        if (!history.isEmpty()) undone.push(history.pop()).undo();
    }

    public void redo() {
        if (!undone.isEmpty()) executeCommand(undone.pop());
    }
}
