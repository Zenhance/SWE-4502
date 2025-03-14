import java.io.*;
import java.util.ArrayList;
import java.util.List;

class History {
    private static final String FILE_NAME = "memento.ser";
    private List<EditorMemento> history = new ArrayList<>();

    public void backup(TextEditor editor) {
        history.add(editor.createMemento());
        saveToFile();
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            editor.restoreFromMemento(history.remove(history.size() - 1));
            saveToFile();
        } else {
            System.out.println("No undo history available.");
        }
    }

    private void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(history);
        } catch (IOException e) {
            System.out.println("Failed to save history.");
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                history = (List<EditorMemento>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("No previous history found.");
            }
        }
    }
}
