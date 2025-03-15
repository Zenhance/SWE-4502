import java.io.*;
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

        }

        EditorMemento memento = mementos.remove(mementos.size() - 1);
        textEditor.restoreFromMemento(memento);
        System.out.println("Restored to previous state.");

    }


    public void SaveToFile(String filePath){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(mementos);
            System.out.println("History saved to " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving history to file: " + e.getMessage());
        }

    }

    public void LoadFromFile(String filePath){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            List<EditorMemento> loadedMementos = (List<EditorMemento>) ois.readObject();

            if (loadedMementos != null) {
                mementos.clear();
                mementos.addAll(loadedMementos);
                System.out.println("Loaded " + mementos.size() + " states from " + filePath);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading history from file: " + e.getMessage());
        }

    }


    public EditorMemento getCurrentEditorMemento() {
        if (mementos.isEmpty()) {
            return null;
        }

        return mementos.get(mementos.size() - 1);
    }

}
