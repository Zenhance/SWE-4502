import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

class EditorMemento implements Serializable {
    private final String content;
    private final int cursorPosition;
    private final List<String> selections;

    public EditorMemento(String content, int cursorPosition, List<String> selections) {
        this.content = content;
        this.cursorPosition = cursorPosition;
        this.selections = new ArrayList<>(selections); // ✅ Ensures selections are stored properly
    }

    public String getContent() {
        return content;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    public List<String> getSelections() {
        return new ArrayList<>(selections); // ✅ Returns a copy to avoid modifications
    }
}
