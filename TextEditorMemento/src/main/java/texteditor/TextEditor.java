package texteditor;

import java.util.ArrayList;
import java.util.List;

public class TextEditor implements ISerialization {
    private String content;
    private int cursorPosition;
    private List<String> selections;

    public TextEditor() {
        this.content = "";
        this.cursorPosition = 0;
        this.selections = new ArrayList<>();
    }

    public void setContent(String content) {
        if (content == null) {
            System.out.println("Content cannot be null.");
            return;
        }
        this.content = content;
        if (cursorPosition > content.length()) {
            cursorPosition = content.length();
        }
        System.out.println("Content updated.");
    }

    public void setCursorPosition(int position) {
        if (position < 0 || position > content.length()) {
            System.out.println("Invalid cursor position.");
            return;
        }
        this.cursorPosition = position;
        System.out.println("Cursor position set to " + position);
    }

    public void addSelection(String selection) {
        if (selection != null && !selection.isEmpty()) {
            this.selections.add(selection);
            System.out.println("Selection added: " + selection);
        } else {
            System.out.println("Cannot add empty selection.");
        }
    }

    public void clearSelections() {
        this.selections.clear();
        System.out.println("Selections cleared.");
    }

    public void displayState() {
        System.out.println("----- Editor State -----");
        System.out.println("Content: " + content);
        System.out.println("Cursor at: " + cursorPosition);
        System.out.println("Selections: " + (selections.isEmpty() ? "None" : ""));
        for (String sel : selections) {
            System.out.println("  • " + sel);
        }
        System.out.println("------------------------");
    }

    // Placeholder for serialization (to be done in Issue #5)
    @Override
    public void saveToFile(String filePath) {
        System.out.println("saveToFile() not implemented yet.");
    }

    @Override
    public void loadFromFile(String filePath) {
        System.out.println("loadFromFile() not implemented yet.");
    }
    public EditorMemento createMemento() {
        return new EditorMemento(content, cursorPosition, selections);
    }

    public void restoreFromMemento(EditorMemento memento) {
        if (memento == null) {
            System.out.println("No memento to restore from.");
            return;
        }
        this.content = memento.getContent();
        this.cursorPosition = memento.getCursorPosition();
        this.selections = memento.getSelections(); // deep copy
        System.out.println("State restored from memento.");
    }

    public String getContent() {
        return content;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    public List<String> getSelections() {
        return selections;
    }


}
