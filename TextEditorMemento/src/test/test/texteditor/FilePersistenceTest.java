package texteditor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FilePersistenceTest {

    private final String filePath = "test.tdump";

    @AfterEach
    void cleanup() {
        File file = new File(filePath);
        if (file.exists()) file.delete();
    }

    @Test
    void saveAndLoadState_ShouldPreserveEditorState() {
        TextEditor editor = new TextEditor();
        History history = new History(editor);

        editor.setContent("Persistent content");
        editor.setCursorPosition(3);
        editor.addSelection("SaveMe");
        history.backup();

        history.saveToFile(filePath);
        assertTrue(new File(filePath).exists());

        // Reset editor and history
        editor.setContent("");
        editor.setCursorPosition(0);
        editor.clearSelections();

        history.loadFromFile(filePath);
        history.undo();  // Restore last backup

        assertEquals("Persistent content", editor.getContent());
        assertEquals(3, editor.getCursorPosition());
        assertTrue(editor.getSelections().contains("SaveMe"));
    }
}
