package Editor;

import java.util.ArrayList;
import java.util.List;

// Placeholder for TextEditor class
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
        this.cursorPosition=content.length();
    }

    public void setCursorPosition(int position) {
        if (position < 0 || position > content.length()) {
            throw new IllegalArgumentException("Invalid cursor position.");
        }
        this.cursorPosition = position;
    }

    public void addSelection(String selection) {
        selections.add(selection);
    }

    public void clearSelections(){
        selections.clear();
    }

    public void displayState() {
        System.out.println("Content: " + content);
        System.out.println("Cursor Position: " + cursorPosition);
        System.out.println("Selections: " + selections);
    }

    public String getContent() {
        return content;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    public List<String> getSelections() {
        return selections;
    }


}
