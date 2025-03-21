import java.util.Stack;

public class CommandHistory {
    private Stack<Command> history = new Stack<>();

    public void executeCommand(Command command){
        command.execute();
        history.push(command);
    }

    public void undo(){
        if(!history.isEmpty()){
            Command command = history.pop();
            command.undo();
        }
    }

    public void redo() {
        if (!history.isEmpty()) {
            Command command = history.peek();
            command.execute();
        }
    }

    public void push(Command command) {
        history.push(command);
    }

    public Command pop() {
        return history.isEmpty() ? null : history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public Command peek() {
        return history.isEmpty() ? null : history.peek();
    }
}
