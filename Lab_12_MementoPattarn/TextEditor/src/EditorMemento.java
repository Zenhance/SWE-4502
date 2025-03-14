import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EditorMemento implements Serializable
{
    private static final long serialVersionUID=1;
    private final String content;
    private final int cursorPosition;

    private final List<String> selections;

    public EditorMemento(String content, int cursorPosition, List<String> selections) {
        this.content = content;
        this.cursorPosition = cursorPosition;
        this.selections = selections;
    }

    public String getContent() {
        return content;
    }
    public int getCursorPosition() {
        return cursorPosition;
    }

    public List<String> getSelections() {
        return new ArrayList<>(selections);
    }
}
