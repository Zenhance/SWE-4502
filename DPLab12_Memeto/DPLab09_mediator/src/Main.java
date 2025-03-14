public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        // Initial state
        editor.setContent("New content!");
        editor.setCursorPosition(4);
        editor.addSelection("New");
        history.backup(editor.createMemento());

        // Display initial state
        System.out.println("Initial State:");
        editor.displayState();

        // Modify state (e.g., new action)
        editor.setContent("Updated content!");
        editor.setCursorPosition(10);
        editor.addSelection("Updated");
        history.backup(editor.createMemento());

        // Display updated state
        System.out.println("\nAfter Modification:");
        editor.displayState();

        // Undo the change
        if (history.undo()) {
            editor.restoreFromMemento(history.getCurrentMemento());
        }

        // Display state after undo
        System.out.println("\nAfter Undo:");
        editor.displayState();

        // Modify state again (e.g., new action)
        editor.setContent("Newer content!");
        editor.setCursorPosition(15);
        editor.addSelection("Newer");
        history.backup(editor.createMemento());

        // Display state after new modification
        System.out.println("\nAfter New Modification:");
        editor.displayState();

        // Undo the change
        if (history.undo()) {
            editor.restoreFromMemento(history.getCurrentMemento());
        }

        // Display state after undo
        System.out.println("\nAfter Undo Again:");
        editor.displayState();
    }
}
