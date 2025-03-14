import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import texteditor.EditorMemento;
import texteditor.FilePersistence;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FilePersistenceTest {
    private static final String TEST_FILE = "test_editor_history.txt";

    @BeforeEach
    void setUp() {
        // Clear the test file before running tests
        new File(TEST_FILE).delete();
    }

    @Test
    void saveToFile_ShouldWriteToFile() {
        List<EditorMemento> history = new ArrayList<>();
        history.add(new EditorMemento("Test Content", 5, List.of("Selection1")));

        FilePersistence.saveToFile(history);
        File file = new File("editor_history.txt");
        assertTrue(file.exists() && file.length() > 0);
    }

    @Test
    void loadFromFile_ShouldReturnValidData() {
        List<EditorMemento> history = new ArrayList<>();
        history.add(new EditorMemento("Saved Content", 2, List.of("TestSelection")));

        FilePersistence.saveToFile(history);
        List<EditorMemento> loadedHistory = FilePersistence.loadFromFile();

        assertFalse(loadedHistory.isEmpty());
        assertEquals("Saved Content", loadedHistory.get(0).getContent());
        assertEquals(2, loadedHistory.get(0).getCursorPosition());
        assertTrue(loadedHistory.get(0).getSelections().contains("TestSelection"));
    }
}
