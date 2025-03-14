package Editor;

import java.util.Stack;

public class History {
    private final TextEditor editor;
    private final Stack<EditorMemento> mementoStack;

    public History(TextEditor editor) {
        this.editor = editor;
        this.mementoStack = new Stack<>();
    }

    public void backup(){
        mementoStack.push(editor.createMemento());
    }

    // Undo to the previous state
    public void undo(){
        if(!mementoStack.isEmpty()){
            mementoStack.pop();
            EditorMemento memento=mementoStack.pop();
            editor.restoreFromMemento(memento);
        }
    }

    // Check if undo is possible
    public boolean canUndo() {
        return !mementoStack.isEmpty();
    }
}
