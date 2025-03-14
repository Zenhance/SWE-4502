import java.util.ArrayList;
import java.util.List;

public class History {
    private List<EditorMemento> history;
    private TextEditor editor;

    public History(TextEditor editor) {
        this.editor = editor;
        this.history = new ArrayList<>(); // Ensure list is initialized
    }

    public void backup() {
        history.add(editor.createMemento()); // No longer causes NullPointerException
    }

    public void undo() {
        if (!history.isEmpty()) {
            EditorMemento memento = history.remove(history.size() - 1);
            editor.restoreFromMemento(memento);
        } else {
            System.out.println("No history to undo.");
        }
    }
}
