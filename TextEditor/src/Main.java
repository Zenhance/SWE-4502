public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History(editor);

        editor.setContent("Hello, World!");
        editor.setCursorPosition(5);
        editor.addSelection("Hello");
        history.backup();

        editor.displayState();

        editor.setContent("New Content");
        editor.setCursorPosition(3);
        history.backup();

        System.out.println("\nAfter Modification:");
        editor.displayState();

        history.undo();
        System.out.println("\nAfter Undo:");
        editor.displayState();
    }
}
