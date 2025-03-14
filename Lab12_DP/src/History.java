import java.io.*;
import java.util.ArrayList;
import java.util.List;

class History {
    private static final String FILE_NAME = "history.ser";
    private List<EditorMemento> history = new ArrayList<>();

    public void backup(TextEditor editor) {
        history.add(editor.createMemento());
        saveToFile();
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            history.remove(history.size() - 1);

            if (!history.isEmpty()) {
                // ✅ Restore the last valid state
                EditorMemento lastState = history.get(history.size() - 1);
                editor.restoreFromMemento(lastState);
            } else {
                // If history is empty, reset editor
                editor.setContent("");
                editor.setCursorPosition(0);
                editor.clearSelections();
            }

            // Debugging
            System.out.println("Undo performed. Restored content: " + editor.createMemento().getContent());
            System.out.println("Restored selections: " + editor.createMemento().getSelections());
        } else {
            System.out.println("No undo history available.");
        }
    }


    private void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(history);
        } catch (IOException e) {
            System.out.println("Failed to save history: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                history = (List<EditorMemento>) in.readObject();
                System.out.println("History loaded successfully.");

                // ✅ Automatically restore the last saved state
                if (!history.isEmpty()) {
                    System.out.println("Restoring the latest saved state...");
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Failed to load history: " + e.getMessage());
            }
        } else {
            System.out.println("No previous history found.");
        }
    }

}
