import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class History implements Serializable
{
    private static final long serialVersionUID=1L;

    private transient TextEditor editor;//transient keyword is used to indicate that a field should not be serialized. This is useful when a field contains data that should not be saved, such as a password or a temporary variable.
    private final List<EditorMemento> history;

    public History(TextEditor editor) {
        this.editor = editor;
        this.history = new ArrayList<>();
    }

    public void backup() {
        System.out.println("History: Saving editor state...");
        history.add(editor.createMemento());
        System.out.println("History: State saved successfully. (Total states: " + history.size() + ")");
    }

    public void undo()
    {
        if (history.isEmpty()) {
            System.out.println("History: No states to restore.");
            return;
        }
        else
        {
            int lastIndex = history.size() - 1;
            EditorMemento memento=history.remove(lastIndex);

            System.out.println("History: Restoring to previous state...");
            editor.restoreFromMemento(memento);
            System.out.println("History: State restored successfully. (Total states: " + history.size() + ")");

        }
    }

    public void saveToFile(String filepath)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {
            oos.writeObject(history);
            System.out.println("History: Successfully saved " + history.size() + " states to " + filepath);
        } catch (IOException e) {
            System.err.println("History: Failed to save states to file: " + e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            List<EditorMemento> loadedHistory = (List<EditorMemento>) ois.readObject();

            if (loadedHistory != null && !loadedHistory.isEmpty()) {
                history.clear();
                history.addAll(loadedHistory);

                // Restore the last state
                if (editor != null) {
                    editor.restoreFromMemento(history.get(history.size() - 1));
                }
                System.out.println("History: Successfully loaded " + history.size() + " states from " + filePath);
            } else {
                System.out.println("History: No states found in file or file is empty.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("History: Failed to load states from file: " + e.getMessage());
        }
    }

    // Called after deserialization to reset the editor reference
    public void setEditor(TextEditor editor) {
        this.editor = editor;
    }



}
