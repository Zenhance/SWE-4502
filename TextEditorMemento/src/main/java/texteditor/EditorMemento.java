package main.java.texteditor;

import java.util.List;
import java.util.ArrayList;

public class EditorMemento {
    private final String content;
    private final int cursorPosition;
    private final List<String> selections;

    public EditorMemento(String content, int cursorPosition, List<String> selections) {
        this.content = content;
        this.cursorPosition = cursorPosition;
        // Deep copy to avoid outside modification
        this.selections = new ArrayList<>(selections);
    }

    public String getContent() {
        return content;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    public List<String> getSelections() {
        return new ArrayList<>(selections); // Return deep copy
    }
}
