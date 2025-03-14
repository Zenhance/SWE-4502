public class Main {
    public static void main(String[] args) {


        TextEditor editor = new TextEditor();
        editor.setContent("Hello, World!");
        editor.setCursorPosition(5);
        editor.addSelection("Hello");

        editor.displayState();

        editor.setContent("New Content");
        editor.setCursorPosition(3);

        System.out.println("\nAfter Modification:");
        editor.displayState();
    }
}