package Editor;


import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilePersistence {

    private final Gson gson;

    public FilePersistence() {
        this.gson = new Gson();
    }

    // Save the editor state to a JSON file
    public void saveToFile(TextEditor editor, String filePath) throws IOException {
        EditorMemento memento = editor.createMemento();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(memento, writer);
        }
    }

    // Load the editor state from a JSON file
    public void loadFromFile(TextEditor editor, String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            EditorMemento memento = gson.fromJson(reader, EditorMemento.class);
            editor.restoreFromMemento(memento);
        }
    }
}
