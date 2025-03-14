package textEditor;

public class EditorMemento {
    private String content;
    private int cursorPosition;
    private String selection;

    public EditorMemento(String _content, int _cursorPosition, String _selection){
        this.content = _content;
        this.cursorPosition = _cursorPosition;
        this.selection= _selection;

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
