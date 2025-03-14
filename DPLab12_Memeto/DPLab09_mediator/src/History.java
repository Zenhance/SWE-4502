import java.util.ArrayList;
import java.util.List;

public class History {
    private List<EditorMemento> history = new ArrayList<>();
    private int currentIndex = -1;

    // Add a new state to the history list and update the currentIndex
    public void backup(EditorMemento memento) {
        if (currentIndex < history.size() - 1) {
            history = history.subList(0, currentIndex + 1);  // Truncate history if we are in the middle of the stack
        }
        history.add(memento);
        currentIndex++;
    }

    // Undo operation: move to the previous state in history
    public boolean undo() {
        if (currentIndex > 0) {
            currentIndex--;
            return true;
        }
        return false;
    }

    // Redo operation: move to the next state in history
    public boolean redo() {
        if (currentIndex < history.size() - 1) {
            currentIndex++;
            return true;
        }
        return false;
    }

    // Get the current memento (state)
    public EditorMemento getCurrentMemento() {
        return history.get(currentIndex);
    }
}
