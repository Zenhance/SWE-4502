package texteditor;

import java.util.ArrayList;
import java.util.List;

public class History {
    private final TextEditor editor;
    private final List<EditorMemento> history;

    // Implementing the Constructor
    public History(TextEditor editor) {
        this.editor = editor;
        this.history = new ArrayList<>();
    }

    // This method is to save the current state
    public void backup() {
        history.add(editor.createMemento());
        System.out.println("Backup saved.");
    }

    // This method is to restore the last saved state
    public void undo() {
        if (!history.isEmpty()) {
            EditorMemento memento = history.remove(history.size() - 1);
            editor.restoreFromMemento(memento);
            System.out.println("Undo successful.");
        } else {
            System.out.println("No history available!");
        }
    }

    // This method is to save history to text file
    public void saveHistory() {
        FilePersistence.saveToFile(history);
    }

    // This method is to load history from text file
    public void loadHistory() {
        List<EditorMemento> loadedHistory = FilePersistence.loadFromFile();
        if (loadedHistory != null && !loadedHistory.isEmpty()) {
            history.clear();
            history.addAll(loadedHistory);
            System.out.println("History loaded successfully.");
        } else {
            System.out.println("No previous history found.");
        }
    }
}
