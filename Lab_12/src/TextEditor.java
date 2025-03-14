import java.util.ArrayList;
import java.util.List;

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
    }

    public void setCursorPosition(int position) {
        if (position >= 0 && position <= content.length()) {
            this.cursorPosition = position;
        }
    }

    public void addSelection(String selection) {
        selections.add(selection);
    }

    public void clearSelections() {
        selections.clear();
    }

    public EditorMemento createMemento() {
        return new EditorMemento(content, cursorPosition, new ArrayList<>(selections));
    }

    public void restoreFromMemento(EditorMemento memento) {
        this.content = memento.getContent();
        this.cursorPosition = memento.getCursorPosition();
        this.selections = new ArrayList<>(memento.getSelections());
    }

    public String getContent() {
        return content;
    }
}
