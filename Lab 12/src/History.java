import java.util.Stack;

public class History {
    private final Stack<EditorMemento> mementoStack;

    public History() {
        mementoStack = new Stack<>();
    }

    public void backup(TextEditor editor) {
        mementoStack.push(editor.createMemento());
    }

    public void undo(TextEditor editor) {
        if (!mementoStack.isEmpty()) {
            EditorMemento memento = mementoStack.pop();
            editor.restoreFromMemento(memento);
        } else {
            System.out.println("No history to undo.");
        }
    }
}

