public class Program {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
//        editor.setContent("Hello, World!");
//        editor.setCursorPosition(7);
//        editor.addSelection("World");
//        editor.displayState();

        EditorMemento memento = editor.createMemento();

        editor.setContent("Goodbye, World!");
        editor.setCursorPosition(9);
        editor.clearSelections();
        editor.displayState();

        editor.restoreFromMemento(memento);
        editor.displayState();







    }
}