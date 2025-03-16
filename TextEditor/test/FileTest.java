import textEditor.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileTest {

    private TextEditor editor;
    private History history;
    private String testFilePath = "testHistory.txt";

    @BeforeEach
    public void setUp() {
        editor = new TextEditor();
        history = new History(editor);
    }

    @Test
    public void saveAndLoadState_ShouldPreserveEditorState() {
        editor.setContent("Test content");
        editor.setCursorPosition(5);
        editor.addSelection("content");
        history.backup();
        history.saveToFile(testFilePath);

        editor.setContent("");
        editor.setCursorPosition(0);
        editor.clearSelections();

        history.loadFromFile(testFilePath);

        int size = history.getMementos().size() - 1;
        EditorMemento loadedMemento = history.getMementos().get(size);

        assertEquals("Test content", loadedMemento.getContent());
        assertEquals(5, loadedMemento.getCursorPosition());
        assertEquals("content", loadedMemento.getSelection());
    }

    @Test
    public void testLoadFileFromExistingFile() {

        history.loadFromFile(testFilePath);
        assertFalse(history.getMementos().isEmpty());
    }

    @Test
    public void testLoadFileFromNonExistingFile() {

        history.loadFromFile("notThere.txt");
        assertTrue(history.getMementos().isEmpty());
    }

}
