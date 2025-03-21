package history;

import issues.Issue;

import java.util.Stack;

public class History {
    public Stack<Memento> history = new Stack<>();
    public void saveState(Memento memento){
        history.push(memento);
    }
    public void undo(Issue issue){
        if(!history.isEmpty()){
            Memento memento = history.pop();
            issue.restore(memento);
        }
    }
}
