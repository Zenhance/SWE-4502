import java.util.ArrayList;
import java.util.List;

class TextEditor {
    private String content = "";
    private int cursorPosition = 0;
    private List<String> selections = new ArrayList<>();

    public void setContent(String content) {
        this.content = content;
    }

    public void setCursorPosition(int position) {
        if (position >= 0 && position <= content.length()) {
            this.cursorPosition = position;
        } else {
            System.out.println("Invalid cursor position.");
        }
    }

    public void addSelection(String selection) {
        selections.add(selection);
    }

    public void clearSelections() {
        selections.clear();
    }

    public EditorMemento createMemento() {
        return new EditorMemento(content, cursorPosition, selections);
    }

    public void restoreFromMemento(EditorMemento memento) {
        this.content = memento.getContent();
        this.cursorPosition = memento.getCursorPosition();
        this.selections = new ArrayList<>(memento.getSelections());
    }

    public void displayState() {
        System.out.println("Content: " + content);
        System.out.println("Cursor Position: " + cursorPosition);
        System.out.println("Selections: " + selections);
    }
}
