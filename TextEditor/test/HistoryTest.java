import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class HistoryTest {
    private TextEditor editor;
    private History history;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalSystemOut = System.out;

    @BeforeEach
    void setUp() {
        editor = new TextEditor();
        history = new History(editor);
        System.setOut(new PrintStream(outContent)); // Redirect System.out to capture output
    }

    @Test
    void testBackupAndUndo() {
        editor.setContent("Initial Content");
        editor.setCursorPosition(5);
        editor.addSelection("Selection 1");
        history.backup();

        // Modify the content and cursor position
        editor.setContent("Modified Content");
        editor.setCursorPosition(0);

        // Undo the change and check if the content is restored
        history.undo();
        assertEquals("Initial Content", editor.createMemento().getContent());
        assertEquals(5, editor.createMemento().getCursorPosition());
        assertTrue(editor.createMemento().getSelections().contains("Selection 1"));
    }

    @Test
    void testUndoWithoutBackup() {
        history.undo();
        assertEquals("No previous state to restore.", outContent.toString().trim());
    }

    @AfterEach
    void restoreSystemOut() {
        System.setOut(originalSystemOut); // Restore original System.out
    }
}
