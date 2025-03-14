import java.io.Serializable;
import java.util.List;

class EditorMemento implements Serializable {
    private final String content;
    private final int cursorPosition;

    private final List<String> selections;


    public EditorMemento(String content, int cursonPosition, List<String> selections) {
        this.content = content;
        this.cursorPosition = cursonPosition;
        this.selections = selections;
    }

    public String getContent() {
        return content;
    }

    public int getCursorPosition(){
        return cursorPosition;
    }

    public List<String> getSelections(){
        return selections;
    }
}
