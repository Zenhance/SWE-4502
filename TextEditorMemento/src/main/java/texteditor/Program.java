package main.java.texteditor;

public class Program {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History(editor);

        editor.setContent("Version 1");
        editor.setCursorPosition(3);
        editor.addSelection("One");
        history.backup();  // Save state 1

        editor.setContent("Version 2");
        editor.setCursorPosition(5);
        editor.addSelection("Two");
        history.backup();  // Save state 2

        editor.setContent("Version 3");
        editor.setCursorPosition(8);
        editor.addSelection("Three");
        editor.displayState();

        // Undo twice
        history.undo();
        editor.displayState();

        history.undo();
        editor.displayState();

        // Try undo beyond history
        history.undo(); // Should show "No previous state to restore."
    }
}
