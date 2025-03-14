import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create an instance of TextEditor and History
        TextEditor editor = new TextEditor();
        History history = new History();

        // Perform some actions
        editor.setContent("Initial content!");
        editor.setCursorPosition(5);
        editor.addSelection("Initial selection");
        history.backup(editor.createMemento());

        editor.setContent("Updated content!");
        editor.setCursorPosition(10);
        editor.addSelection("Updated selection");
        history.backup(editor.createMemento());

        // Save history to file
        FilePersistence.saveToFile("history.dat", history.history);

        // Modify editor again
        editor.setContent("Another content change");
        editor.setCursorPosition(15);
        editor.addSelection("Another selection");
        history.backup(editor.createMemento());

        // Load history from file
        List<EditorMemento> loadedHistory = FilePersistence.loadFromFile("history.dat");

        // If the history is loaded, print the content of the last state
        if (loadedHistory != null && !loadedHistory.isEmpty()) {
            editor.restoreFromMemento(loadedHistory.get(loadedHistory.size() - 1));
            editor.displayState();
        }
    }
}
