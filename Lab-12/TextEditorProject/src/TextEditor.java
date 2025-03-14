import java.util.ArrayList;
import java.util.List;

public class TextEditor {
    private String content;
    private int cursorPosition;
    private List<String> selections;

    public TextEditor() {
        this.content = "";
        this.cursorPosition = 0;
        this.selections = new ArrayList<>();
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCursorPosition(int position) {

            this.cursorPosition = position;

    }

    public void addSelection(String selection) {
        selections.add(selection);
    }

    public void clearSelections() {
        selections.clear();
    }

    public void displayState() {
        System.out.println("Content: " + content);
        System.out.println("Cursor Position: " + cursorPosition);
        System.out.println("Selections: " + selections);
    }
}