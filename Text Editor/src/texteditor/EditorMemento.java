package texteditor;

import java.util.List;

public class EditorMemento {
    private final String content;
    private final int cursorPosition;
    private final List<String> selections;

    // Implementing the Constructor
    public EditorMemento(String content, int cursorPosition, List<String> selections) {
        this.content = content;
        this.cursorPosition = cursorPosition;
        this.selections = selections;
    }

    // Getters to retrieve stored state
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
