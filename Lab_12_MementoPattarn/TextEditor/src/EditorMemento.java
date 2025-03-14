import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EditorMemento implements Serializable
{
    private static final long serialVersionUID=1;
    // The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses this number to ensure that a loaded class corresponds exactly to a serialized object. If no match is found, then an InvalidClassException is thrown.
    private final String content;
    private final int cursorPosition;

    private final List<String> selections;

    public EditorMemento(String content, int cursorPosition, List<String> selections) {
        this.content = content;
        this.cursorPosition = cursorPosition;
        this.selections = selections;//store a copy of the selections list
    }

    public String getContent() {
        return content;
    }
    public int getCursorPosition() {
        return cursorPosition;
    }

    public List<String> getSelections() {
        return new ArrayList<>(selections);//return a copy of the selections list
    }
}
