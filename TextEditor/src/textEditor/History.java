package textEditor;

import java.io.*;
import java.util.List;

public class History {
    public TextEditor editor;
    public List<EditorMemento> mementos;

    public History(TextEditor _textEditor) {
        this.editor = _textEditor;
    }

    public void backup() {
        mementos.add(editor.createMemento());
        System.out.println("Saved the current state");
    }

    public void undo() {

    }

    public void saveToFile(String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (EditorMemento mem : mementos) {
                writer.write(mem.getContent() + "\n");
                writer.write(mem.getCursorPosition() + "\n");
                writer.write(mem.getSelection() + "\n");
            }

            System.out.println("History saved to file");
        } catch (IOException e) {
            System.err.println("Error saving history to file");
        }
    }

    public void loadFromFile(String filePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String content;
            while ((content = reader.readLine()) != null) {
                int cursorPosition = Integer.parseInt(reader.readLine());
                String selection = reader.readLine();
                EditorMemento memento = new EditorMemento(content, cursorPosition, selection);
                mementos.add(memento);
            }

            System.out.println("History loaded from file");
        } catch (IOException e) {
            System.err.println("Error loading history from file");

        }
    }
}
