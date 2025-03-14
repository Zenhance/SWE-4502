public class Program {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History(editor);

        // The initial state
        editor.SetContent("Hello, world!");
        editor.SetCursorPosition(5);
        history.Backup();
        editor.DisplayState();

        // Some changes
        editor.SetContent("Hello, Java world!");
        editor.SetCursorPosition(7);
        editor.AddSelection("Java");
        history.Backup();
        System.out.println("\nAfter changes:");
        editor.DisplayState();

        // Undo
        System.out.println("\nAfter undo:");
        history.Undo();
        editor.DisplayState();
    }
}