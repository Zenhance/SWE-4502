package textEditor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class History {
    private TextEditor editor;
    private List<EditorMemento> mementos;
    private int count;

    public History(TextEditor _textEditor) {
        this.editor = _textEditor;
        this.mementos = new ArrayList<>();
        this.count = 0;
    }

    public void backup() {
        mementos.add(editor.createMemento());
        count++;
        System.out.println("Saved the current state");
    }

    public void undo() {
        if (count > 1) {
            count --;
            EditorMemento mem = mementos.get(count-1);
            editor.restoreFromMemento(mem);
            System.out.println("Undo Performed.");

        } else if(count == 1){
            count --;
            EditorMemento mem = new EditorMemento("",0,"");
            editor.restoreFromMemento(mem);
            System.out.println("Undo Performed. No more undo can be done.");

        }
        else {
            System.out.println("Cannot undo.");
        }
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
            count = mementos.size();
            System.out.println("History loaded from file: "+ filePath);
        } catch (IOException e) {
            System.err.println("Error loading history from file: "+ filePath);

        }
    }

    public List<EditorMemento> getMementos(){
        return mementos;
    }

    public int getCount(){
        return count;
    }
}
