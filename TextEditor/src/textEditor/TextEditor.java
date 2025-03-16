package textEditor;


public class TextEditor {
    private String content;
    private int cursorPosition;
    private String selection;

    public TextEditor() {
        this.content = "";
        this.cursorPosition = 0;
        this.selection = "";
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


    public String getContent(){
        return content;
    }

    public int getCursorPosition(){
        return cursorPosition;
    }

    public String getSelection(){
        return selection;
    }
}
