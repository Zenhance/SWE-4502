import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HistoryTest {

    private History history;
    private TextEditor editor;

    @BeforeEach
    void setUp() {
        history = new History();
        editor = new TextEditor();
    }

    @Test
    void testBackupAndUndo() {
        editor.setContent("First Version");
        editor.setCursorPosition(5);
        editor.addSelection("First");
        history.backup(editor);

        editor.setContent("Second Version");
        editor.setCursorPosition(10);
        editor.addSelection("Second");
        history.backup(editor);

        history.undo(editor);

        assertEquals("First Version", editor.createMemento().getContent(), "Undo should restore the first version.");
        assertEquals(5, editor.createMemento().getCursorPosition(), "Undo should restore the correct cursor position.");
        assertEquals(1, editor.createMemento().getSelections().size(), "Undo should restore selections.");
    }

    @Test
    void testUndoWithEmptyHistory() {
        history.undo(editor);
        assertEquals("", editor.createMemento().getContent(), "Editor content should remain empty when no history is present.");
    }

    @Test
    void testSaveAndLoadHistory() {
        editor.setContent("Saved State");
        editor.setCursorPosition(3);
        editor.addSelection("Saved");
        history.backup(editor);

        // Simulate application restart by creating a new History instance
        History newHistory = new History();
        newHistory.loadFromFile();

        newHistory.undo(editor);

        assertEquals("Saved State", editor.createMemento().getContent(), "Editor should restore from saved file.");
        assertEquals(3, editor.createMemento().getCursorPosition(), "Editor should restore cursor position from file.");
        assertEquals(1, editor.createMemento().getSelections().size(), "Editor should restore selections from file.");
    }
}
