public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History(editor);

        // Simulating user actions
        editor.setContent("Hello, World!");
        history.backup();

        editor.setContent("Updated content.");
        history.backup();

        System.out.println("Current Content: " + editor.getContent());

        // Undo last change
        history.undo();
        System.out.println("After Undo: " + editor.getContent());
    }
}
