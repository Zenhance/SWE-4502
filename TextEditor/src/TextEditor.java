import java.util.ArrayList;
import java.util.List;

public class TextEditor {
    private String content;
    private int cursorPosition;
    private List<String> selections; // Made selections final for better design

    public TextEditor() {
        this.content = "";
        this.cursorPosition = 0;
        this.selections = new ArrayList<>();
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCursorPosition(int position) {
        if (position < 0 || position > content.length()) {
            throw new IllegalArgumentException("Invalid cursor position");
        }
        this.cursorPosition = position;
    }

    public void addSelection(String selection) {
        selections.add(selection);
    }

    public void clearSelections() {
        selections.clear();
    }

    public void displayState() {
        System.out.println("Content: " + content);
        System.out.println("Cursor Position: " + cursorPosition);
        System.out.println("Selections: " + selections);
    }

    public EditorMemento createMemento() {
        return new EditorMemento(content, cursorPosition, new ArrayList<>(selections));
    }

    public void restoreFromMemento(EditorMemento memento) {
        this.content = memento.getContent();
        this.cursorPosition = memento.getCursorPosition();
        this.selections = new ArrayList<>(memento.getSelections());
    }
}
