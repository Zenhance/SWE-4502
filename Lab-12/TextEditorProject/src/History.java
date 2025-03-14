import java.util.ArrayList;
import java.util.List;

public class History {
    private final TextEditor editor;
    private final List<EditorMemento> mementos;

    public History(TextEditor editor) {
        this.editor = editor;
        this.mementos = new ArrayList<>();
    }

    public void backup() {
        mementos.add(editor.createMemento());
    }

    public void undo() {
        if (mementos.isEmpty()) {
            System.out.println("No states to undo.");
            return;
        }
        EditorMemento memento = mementos.remove(mementos.size() - 1);
        editor.restoreFromMemento(memento);
    }
}