package textEditor;

import javax.accessibility.AccessibleEditableText;

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
        if (_position >= 0 && _position <= content.length())
        {
            this.cursorPosition = _position;
        } else {
            System.out.println("Not valid cursor position.");
        }
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

    public EditorMemento createMemento(){
        return new EditorMemento(this.content,this.cursorPosition,this.selection);
    }

    public void restoreFromMemento(EditorMemento memento){
        content = memento.getContent();
        cursorPosition = memento.getCursorPosition();
        selection = memento.getSelection();
    }
}
