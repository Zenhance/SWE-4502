import java.util.Stack;

public class History {
    public Stack<Memento> history = new Stack<>();
    public void saveState(Memento memento){
        history.push(memento);
    }
    public void undo(TextEditor textEditor){
        if(!history.isEmpty()){
            Memento memento = history.pop();
            textEditor.restore(memento);
        }
    }
}
