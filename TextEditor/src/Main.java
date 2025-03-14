public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History(editor);

        editor.setContent("Hello, World!");
        editor.setCursorPosition(5);
        editor.displayState();

        history.backup();  // Save state

        editor.setContent("New content");
        editor.setCursorPosition(3);
        editor.displayState();

        history.undo();  // Restore previous state
        editor.displayState();

        // File persistence example
        String filePath = "editor_state.json";
        FilePersistence.saveToFile(editor.createMemento(), filePath);
        EditorMemento loadedMemento = FilePersistence.loadFromFile(filePath);

        if (loadedMemento != null) {
            editor.restoreFromMemento(loadedMemento);
            System.out.println("Loaded state:");
            editor.displayState();
        }
    }
}
