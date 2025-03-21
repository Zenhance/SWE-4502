import java.util.Stack;

public class CommandInvoker {
    private Stack<Command> commandStack= new Stack<>();

    private Stack<Command> undoStack = new Stack<>();

    public void undo(){
        if(!commandStack.isEmpty()){
            Command command = commandStack.pop();
            command.undo();
            undoStack.push(command);
        }
    }

    public void redo(){
        if(!commandStack.isEmpty()){
            Command command = commandStack.pop();
            command.execute();
            commandStack.push(command);
        }
    }

}
