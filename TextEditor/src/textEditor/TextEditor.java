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

}
