
import java.util.Stack;

public class History {
    Command backup;
    private Stack<Command> history;

    public History() {
        history= new Stack<>();
    }


    public void push(Command c){
        if (!history.isEmpty()) {
            backup = history.peek();
            history.push(c);
        }
    }

    public Command pop() {
        if (!history.isEmpty()) {
            history.pop();
            return backup = history.peek();
        }
        else {
            return null;
        }
    }
}
