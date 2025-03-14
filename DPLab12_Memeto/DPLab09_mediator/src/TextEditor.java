public class TextEditor {
    private String content;
    private int cursorPosition;
    private String selection;

    public TextEditor() {
        this.content = "";
        this.cursorPosition = 0;
        this.selection = "";
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCursorPosition(int position) {
        this.cursorPosition = position;
    }

    public void addSelection(String selection) {
        this.selection = selection;
    }

    public void clearSelections() {
        this.selection = "";
    }

    public void displayState() {
        System.out.println("Content: " + content);
        System.out.println("Cursor Position: " + cursorPosition);
        System.out.println("Selection: " + selection);
    }

    // Method to create a memento of the current state
    //current state e use hoi
    public EditorMemento createMemento() {
        return new EditorMemento(content, cursorPosition, selection);
    }

    // Method to restore the state from a memento
    //undo teh use hoi
    public void restoreFromMemento(EditorMemento memento) {
        this.content = memento.getContent();
        this.cursorPosition = memento.getCursorPosition();
        this.selection = memento.getSelection();
    }
}
