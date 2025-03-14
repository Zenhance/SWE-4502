public class Program {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.setContent("Hello, World!");
        editor.setCursorPosition(7);
        editor.addSelection("World");
        editor.displayState();



    }
}