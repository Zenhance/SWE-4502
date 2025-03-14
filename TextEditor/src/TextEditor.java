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

    public void SetContent(String content) {
        this.content = content;
        if (this.cursorPosition > content.length()) {
            this.cursorPosition = content.length();
        }
    }

    public void SetCursorPosition(int position) {
        if (position < 0) {
            this.cursorPosition = 0;
        } else if (position > this.content.length()) {
            this.cursorPosition = this.content.length();
        } else {
            this.cursorPosition = position;
        }
    }

    public void AddSelection(String selection) {
        selections.add(selection);
    }

    public void ClearSelections() {
        selections.clear();
    }

    public void DisplayState() {
        System.out.println("Current Text: " + content);
        System.out.println("Cursor Position: " + cursorPosition);

        if (!selections.isEmpty()) {
            System.out.println("Selections:");
            for (String selection : selections) {
                System.out.println("- " + selection);
            }
        } else {
            System.out.println("No active selections");
        }
    }

    public EditorMemento CreateMemento() {
        return new EditorMemento(content, cursorPosition, new ArrayList<>(selections));
    }

    public void RestoreFromMemento(EditorMemento memento) {
        this.content = memento.getContent();
        this.cursorPosition = memento.getCursorPosition();
        this.selections = new ArrayList<>(memento.getSelections());
    }
}