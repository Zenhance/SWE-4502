import java.util.Stack;

public class History {
    private final TextEditor editor;
    private final Stack<EditorMemento> historyStack = new Stack<>();

    public History(TextEditor editor) {
        this.editor = editor;
    }

    public void backup() {
        historyStack.push(editor.createMemento());
    }

    public void undo() {
        if (!historyStack.isEmpty()) {
            EditorMemento previousState = historyStack.pop();
            editor.restoreFromMemento(previousState);
        } else {
            System.out.println("No previous states to undo!");
        }
    }
}
