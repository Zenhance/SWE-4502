import java.util.Stack;

public class History {
    private Stack<EditorMemento> history;
    private TextEditor editor;

    public History(TextEditor editor) {
        this.editor = editor;
        this.history = new Stack<>();
    }

    public void backup() {
        history.push(editor.createMemento());
    }

    public void undo() {
        if (!history.isEmpty()) {
            editor.restoreFromMemento(history.pop());
        } else {
            System.out.println("No previous state to restore.");
        }
    }
}
