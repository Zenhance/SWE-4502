package texteditor;

public class Program {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History(editor);

        // Create and backup state
        editor.setContent("Initial Content");
        editor.setCursorPosition(4);
        editor.addSelection("Init");
        history.backup();

        editor.setContent("Second Version");
        editor.setCursorPosition(8);
        editor.addSelection("Version");
        history.backup();

        editor.displayState();

        // Save to file
        history.saveToFile("editor.tdump");

        // Clear editor and history to simulate a restart
        editor.setContent("");
        editor.setCursorPosition(0);
        editor.clearSelections();
        editor.displayState();

        // Load from file
        history.loadFromFile("editor.tdump");

        // Undo to restore last saved state
        history.undo();
        editor.displayState();
    }
}
