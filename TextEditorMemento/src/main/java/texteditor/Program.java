package main.java.texteditor;

public class Program {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        // Initial state setup
        editor.setContent("Hello, World!");
        editor.setCursorPosition(5);
        editor.addSelection("Hello");
        editor.addSelection("World");
        editor.displayState();

        // Create memento after initial setup
        EditorMemento snapshot = editor.createMemento();

        // Modify the editor state
        editor.clearSelections();
        editor.setContent("New content!");
        editor.setCursorPosition(0);
        editor.displayState();

        // Restore to snapshot
        editor.restoreFromMemento(snapshot);
        editor.displayState();
    }
}
