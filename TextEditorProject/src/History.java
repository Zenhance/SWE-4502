import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class History implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient final TextEditor textEditor;


    private final List<EditorMemento> mementos;

    public History(TextEditor textEditor) {
        this.textEditor = textEditor;
        this.mementos = new ArrayList<>();
    }

    public void Backup() {
        mementos.add(textEditor.createMemento());
    }

    public void undo() {
        if (mementos.isEmpty()) {
            System.out.println("History is empty, cannot undo.");
            return;
        }

        EditorMemento memento = mementos.remove(mementos.size() - 1);
        textEditor.restoreFromMemento(memento);
        System.out.println("Restored to previous state.");
    }

    

}
