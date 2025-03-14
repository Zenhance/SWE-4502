package main;
import java.util.Stack;
public class History {
    private Stack<EditorMemento> history = new Stack<>();
    private TextEditor editor;
    public History(TextEditor editor) {
        this.editor = editor;
    }

    public void save(){
        System.out.println("Saving state...");
        history.push(editor.createMemento());
    }

    public void undo(){
        if (!history.isEmpty()) {
            EditorMemento memento = history.pop();
            editor.restoreFromMemento(memento);
            System.out.println("Undo successful!");
        }
        else{
            System.out.println("No history to undo.");
        }

    }
    public boolean isEmpty(){
        return history.isEmpty();
    }

}
