public class TextEditor {
    private String content;
    private int cursorPosition;
    private String selection;
    private final History history;

    public TextEditor() {
        content = "";
        cursorPosition = 0;
        selection = "";
        history = new History(); // Initialize the history to keep track of mementos
    }

    // Method to set content (overwrite existing content)
    public void setContent(String content) {
        history.backup(this); // Backup the current state before setting new content
        this.content = content; // Set the content to the new value
        cursorPosition = content.length(); // Update cursor position
    }

    // Method to write text to the editor (append text to content)
    public void write(String text) {
        history.backup(this); // Backup the current state before writing
        content += text; // Append new text to content
        cursorPosition = content.length(); // Move cursor to the end of the content
    }

    // Undo the last write or content set operation
    public void undo() {
        history.undo(this); // Restore the previous state using History
    }

    // Getter method to get the content
    public String getContent() {
        return content;
    }

    // Create a Memento to store the current state of the editor
    public EditorMemento createMemento() {
        return new EditorMemento(content, cursorPosition, selection);
    }

    // Restore the state from a Memento
    public void restoreFromMemento(EditorMemento memento) {
        this.content = memento.content();
        this.cursorPosition = memento.cursorPosition();
        this.selection = memento.selection();
    }
}
