package texteditor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilePersistence {
    private static final String FILE_PATH = "editor_history.txt";

    // Save history to a text file
    public static void saveToFile(List<EditorMemento> history) {
        if (history.isEmpty()) {
            System.out.println("No history to save.");
            return;
        }

        File file = new File(FILE_PATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) { // Overwrite file each time
            for (EditorMemento memento : history) {
                writer.write(memento.getContent());
                writer.newLine(); // Ensure each field is on a new line
                writer.write(String.valueOf(memento.getCursorPosition()));
                writer.newLine();
                writer.write(String.join(",", memento.getSelections())); // Save selections as comma-separated values
                writer.newLine();
            }

            writer.flush(); // Ensure data is written to the file
            System.out.println("History successfully saved to file: " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }

    // Load history from a text file
    public static List<EditorMemento> loadFromFile() {
        List<EditorMemento> history = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists() || file.length() == 0) {
            System.out.println("History file does not exist or is empty. Skipping load.");
            return history; // Return an empty history instead of null
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String content;
            while ((content = reader.readLine()) != null) {  // Read first line (content)
                String cursorStr = reader.readLine();
                if (cursorStr == null) break; // Prevent null exception

                int cursorPosition = Integer.parseInt(cursorStr);  // Read second line (cursor position)
                String selectionLine = reader.readLine();
                if (selectionLine == null) break; // Prevent null exception

                List<String> selections = selectionLine.isEmpty() ? new ArrayList<>() : List.of(selectionLine.split(","));

                history.add(new EditorMemento(content, cursorPosition, selections));
            }
            System.out.println("History loaded successfully from file.");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading file: " + e.getMessage());
        }
        return history;
    }
}
