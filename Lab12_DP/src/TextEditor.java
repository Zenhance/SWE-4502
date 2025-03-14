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
        this.cursorPosition = position;
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

        // ✅ Ensure previous selections are cleared before restoring
        this.selections.clear();
        this.selections.addAll(memento.getSelections());

        // Debugging
        System.out.println("Restored content: " + this.content);
        System.out.println("Restored cursor position: " + this.cursorPosition);
        System.out.println("Restored selections: " + this.selections);
    }


    public void displayState() {
    }
}
