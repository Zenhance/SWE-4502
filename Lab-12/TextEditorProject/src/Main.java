//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        TextEditor editor = new TextEditor();
        System.out.println("Test 1: Set Content");
        editor.setContent("Hello, world!");
        editor.displayState();
        System.out.println();

        System.out.println("Test 2: Set Cursor Position");
        editor.setCursorPosition(7);
        editor.displayState();
        System.out.println();

        System.out.println("Test 3: Add Selection");
        editor.addSelection("Hello");
        editor.addSelection("world");
        editor.displayState();
        System.out.println();

        System.out.println("Test 4: Clear Selections");
        editor.clearSelections();
        editor.displayState();
        System.out.println();


        System.out.println("Test 5: Update Content");
        editor.setContent("This is a test.");
        editor.setCursorPosition(10);
        editor.displayState();
    }
}