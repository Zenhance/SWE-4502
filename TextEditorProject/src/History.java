import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class History {
    private List<EditorMemento> mementos = new ArrayList<>();

    public void addMemento(EditorMemento memento) {
        mementos.add(memento);
    }

    public List<EditorMemento> getMementos() {
        return mementos;
    }

    // Save history in a user-friendly, readable text format
    public void saveToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (EditorMemento memento : mementos) {
                writer.write("Content: " + memento.getContent() + "\n");
                writer.write("Cursor Position: " + memento.getCursorPosition() + "\n");
                writer.write("Selections: " + String.join(", ", memento.getSelections()) + "\n");
                writer.write("-------------------\n"); // Separator for readability
            }
            System.out.println("History saved in user-friendly format.");
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    // Load history from a file (basic deserialization)
    public void loadFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Content:")) {
                    String content = line.substring(9).trim();
                    String cursorPositionLine = reader.readLine();
                    int cursorPosition = Integer.parseInt(cursorPositionLine.substring(15).trim());
                    String selectionsLine = reader.readLine();
                    String[] selections = selectionsLine.substring(11).split(", ");

                    EditorMemento memento = new EditorMemento(content, cursorPosition, List.of(selections));
                    mementos.add(memento);

                    // Skip the separator line
                    reader.readLine();
                }
            }
            System.out.println("History loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading from file: " + e.getMessage());
            mementos = new ArrayList<>();
        }
    }



}
