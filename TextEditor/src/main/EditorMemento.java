package main;
import java.util.List;


// it stores the state like prince of persia example
public class EditorMemento {
    private final String content;
    private final int cursorPosition;
    private final List<String> selections;

    public EditorMemento(String content, int cursorPosition, List<String> selections) {
        this.content = content;
        this.cursorPosition = cursorPosition;
        this.selections = List.copyOf(selections);
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
