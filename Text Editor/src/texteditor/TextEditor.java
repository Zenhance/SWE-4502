package texteditor;

import java.util.ArrayList;
import java.util.List;

public class TextEditor {
    private String content;
    private int cursorPosition;
    private List<String> selections;

    // Implementing the Constructor
    public TextEditor() {
        this.content = "";
        this.cursorPosition = 0;
        this.selections = new ArrayList<>();
    }

    // This method is to set content
    public void setContent(String content) {
        this.content = content;
    }

    // This method is to set cursor position
    public void setCursorPosition(int position) {
        if (position >= 0 && position <= content.length()) {
            this.cursorPosition = position;
        } else {
            System.out.println("Invalid cursor position!");
        }
    }

    // This method is to add selection
    public void addSelection(String selection) {
        selections.add(selection);
    }

    // This method is to clear selections
    public void clearSelections() {
        selections.clear();
    }

    // This method is to display editor state
    public void displayState() {
        System.out.println("Content: " + content);
        System.out.println("Cursor Position: " + cursorPosition);
        System.out.println("Selections: " + selections);
    }
}
