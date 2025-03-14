package texteditor;

import java.util.ArrayList;
import java.util.List;

// Originator class
public class TextEditor {
    private String content;
    private int cursorPosition;
    private List<String> selections;

    public TextEditor() {
        content = "";
        cursorPosition = 0;
        selections = new ArrayList<>();
    }

    // editor er content set kore.
    public void setContent(String content) {
        this.content = content != null ? content : "";
    }

    // cursor er position
    public void setCursorPosition(int position) {
        // Basic validation
        if (position < 0) {
            cursorPosition = 0;
        } else if (position > content.length()) {
            cursorPosition = content.length();
        } else {
            cursorPosition = position;
        }
    }

    // Add a selection
    public void addSelection(String selection) {
        if (selection != null && !selection.isEmpty()) {
            selections.add(selection);
        }
    }

    // Clear all selections
    public void clearSelections() {
        selections.clear();
    }

    // Display the current state of the editor
    public void displayState() {
        System.out.println("Editor State: Content length: " + content.length() + ", Cursor: " + cursorPosition);
    }

    // Create a memento containing the current state
    public EditorMemento createMemento() {
        return new EditorMemento(content, cursorPosition, selections);
    }

    // Restore state from a memento
    public void restoreFromMemento(EditorMemento memento) {
        if (memento != null) {
            content = memento.getContent();
            cursorPosition = memento.getCursorPosition();
            selections = memento.getSelections();
        }
    }
} 