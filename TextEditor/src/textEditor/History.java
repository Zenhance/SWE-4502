package textEditor;

import java.util.List;

public class History {
    public TextEditor editor;
    public List<EditorMemento> mementos;

    public History(TextEditor _textEditor){
        this.editor = _textEditor;
    }

    public void backup(){
        mementos.add(editor.createMemento());
        System.out.println("Saved the current state");
    }

    public void undo(){

    }
}
