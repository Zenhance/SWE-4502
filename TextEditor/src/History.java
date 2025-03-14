import java.util.ArrayList;
import java.util.List;

public class History {
    private final List<EditorMemento> states;
    private final TextEditor editor;
    private int currentIndex;

    public History(TextEditor editor) {
        this.editor = editor;
        this.states = new ArrayList<>();
        this.currentIndex = -1;
    }

    public void Backup() {
        if (currentIndex < states.size() - 1) {
            states.subList(currentIndex + 1, states.size()).clear();
        }
        states.add(editor.CreateMemento());
        currentIndex = states.size() - 1;
    }

    public void Undo() {
        if (currentIndex <= 0) {
            System.out.println("Cannot undo: No history available");
            return;
        }

        EditorMemento memento = states.get(--currentIndex);
        editor.RestoreFromMemento(memento);
        System.out.println("Undo performed successfully");
    }
}