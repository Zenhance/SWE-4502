package texteditor;

import java.util.Stack;
import java.io.*;
import java.util.ArrayList;

public class History {
    private final Stack<EditorMemento> historyStack = new Stack<>();
    private final TextEditor editor;

    public History(TextEditor editor) {
        this.editor = editor;
    }

    public void backup() {
        EditorMemento memento = editor.createMemento();
        historyStack.push(memento);
        System.out.println("Backup created.");
    }

    public void undo() {
        if (historyStack.isEmpty()) {
            System.out.println("No previous state to restore.");
            return;
        }
        EditorMemento memento = historyStack.pop();
        editor.restoreFromMemento(memento);
        System.out.println("Undo successful.");
    }
    public void saveToFile(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(new ArrayList<>(historyStack));
            System.out.println("Editor state saved to file: " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving state: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            ArrayList<EditorMemento> loaded = (ArrayList<EditorMemento>) ois.readObject();
            historyStack.clear();
            historyStack.addAll(loaded);
            System.out.println("Editor state loaded from file: " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading state: " + e.getMessage());
        }
    }
}
