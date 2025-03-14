import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FilePersistence {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void saveToFile(EditorMemento memento, String filePath) {
        try {
            objectMapper.writeValue(new File(filePath), memento);
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }

    public static EditorMemento loadFromFile(String filePath) {
        try {
            return objectMapper.readValue(new File(filePath), EditorMemento.class);
        } catch (IOException e) {
            System.err.println("Error loading file: " + e.getMessage());
            return null;
        }
    }
}
