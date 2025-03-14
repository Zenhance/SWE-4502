package texteditor;

import java.util.ArrayList;
import java.util.List;

//ey hocche caretaker
public class History {
    private final List<EditorMemento> mementos = new ArrayList<>();
    private final TextEditor editor;

    public History(TextEditor editor) {
        this.editor = editor;
    }

    // ekhane current state ta save hocche
    public void backup() {
        System.out.println("Saving state");
        mementos.add(editor.createMemento());
    }

    // undo basically
    public void undo() {
        if (mementos.isEmpty()) {
            System.out.println("No history available");
            return;
        }

        EditorMemento memento = mementos.remove(mementos.size() - 1);
        System.out.println("Restoring state");
        editor.restoreFromMemento(memento);
    }
} 