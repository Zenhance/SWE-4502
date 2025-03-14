package main.java.texteditor;

public class Program {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.setContent("Hello, World!");
        editor.setCursorPosition(5);
        editor.addSelection("Hello");
        editor.addSelection("World");
        editor.displayState();

        editor.clearSelections();
        editor.displayState();
    }
}
