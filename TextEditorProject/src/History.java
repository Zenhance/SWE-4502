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

    public boolean undo() {
        if (mementos.isEmpty()) {
            System.out.println("History is empty, cannot undo.");
            return false;
        }

        EditorMemento memento = mementos.remove(mementos.size() - 1);
        textEditor.restoreFromMemento(memento);
        System.out.println("Restored to previous state.");
        return true;
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

    // This helps with verifying the loaded state in tests
    public EditorMemento getCurrentEditorMemento() {
        if (mementos.isEmpty()) {
            return null;
        }
        // Return a copy of the last memento without removing it
        return mementos.get(mementos.size() - 1);
    }

}
