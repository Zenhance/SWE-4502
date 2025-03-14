package textEditor;

public class TextEditor {
    private String content;
    private int cursorPosition;
    private String selection;

    public TextEditor(String _content, int _cursorPosition, String _selection) {
        this.content = _content;
        this.cursorPosition = _cursorPosition;
        this.selection = _selection;
    }

    public void setContent(String _content) {
        this.content = _content;
    }

    public void setCursorPosition(int _position) {
        this.cursorPosition = _position;
    }

    public void addSelection(String _selection) {
        this.selection = _selection;
    }

    public void clearSelections() {
        this.selection = "";
    }

    public void displayState() {
        System.out.println("Content: " + content);
        System.out.println("Cursor Position: " + cursorPosition);
        System.out.println("Selection: " + selection);
    }
}
