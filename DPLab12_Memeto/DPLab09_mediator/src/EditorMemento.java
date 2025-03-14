import java.io.Serializable;

public class EditorMemento implements Serializable {
    private static final long serialVersionUID = 1L;
    private String content;
    private int cursorPosition;
    private String selection;

    public EditorMemento(String content, int cursorPosition, String selection) {
        this.content = content;
        this.cursorPosition = cursorPosition;
        this.selection = selection;
    }

    public String getContent() {
        return content;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    public String getSelection() {
        return selection;
    }
}
