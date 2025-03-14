import java.io.*;
import java.util.List;

public class FilePersistence {

    // Save history (List of EditorMemento) to a file
    public static void saveToFile(String filePath, List<EditorMemento> history) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(history);  // Write the list of mementos to the file
            System.out.println("History saved successfully to " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // Load history (List of EditorMemento) from a file
    public static List<EditorMemento> loadFromFile(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            // Read the list of mementos from the file
            return (List<EditorMemento>) in.readObject();
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
            return null;
        }
    }
}
