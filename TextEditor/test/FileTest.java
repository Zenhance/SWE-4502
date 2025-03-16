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
    public void testSaveAndLoadSingleState() {
        editor.setContent("Test content");
        editor.setCursorPosition(5);
        editor.addSelection("content");
        history.backup();
        history.saveToFile(testFilePath);


        TextEditor newEditor = new TextEditor();
        History newHistory = new History(newEditor);
        newHistory.loadFromFile(testFilePath);

        int size = newHistory.getMementos().size() - 1;
        EditorMemento loadedMemento = newHistory.getMementos().get(size);

        assertEquals("Test content", loadedMemento.getContent());
        assertEquals(5, loadedMemento.getCursorPosition());
        assertEquals("content", loadedMemento.getSelection());
    }
}
