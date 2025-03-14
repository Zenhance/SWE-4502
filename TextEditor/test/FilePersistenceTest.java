import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

class FilePersistenceTest {

    @Test
    void testSaveToFile() throws IOException {
        String filePath = "test_memento.json";
        EditorMemento memento = new EditorMemento("Test Content", 5, List.of("Selection 1"));

        FilePersistence.saveToFile(memento, filePath);

        File file = new File(filePath);
        assertTrue(file.exists(), "File should be saved successfully");
        file.delete();  // Clean up the file after test
    }

    @Test
    void testLoadFromFile() throws IOException {
        String filePath = "test_memento.json";
        EditorMemento memento = new EditorMemento("Test Content", 5, List.of("Selection 1"));
        FilePersistence.saveToFile(memento, filePath);

        EditorMemento loadedMemento = FilePersistence.loadFromFile(filePath);

        assertNotNull(loadedMemento, "Memento should be loaded successfully");
        assertEquals("Test Content", loadedMemento.getContent());
        assertEquals(5, loadedMemento.getCursorPosition());
        assertTrue(loadedMemento.getSelections().contains("Selection 1"));

        new File(filePath).delete();  // Clean up the file after test
    }
}
