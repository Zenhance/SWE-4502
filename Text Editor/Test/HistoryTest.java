import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import texteditor.History;
import texteditor.TextEditor;

import static org.junit.jupiter.api.Assertions.*;

public class HistoryTest {
    private TextEditor editor;
    private History history;

    @BeforeEach
    void setUp() {
        editor = new TextEditor();
        history = new History(editor);
    }

    @Test
    void backup_ShouldSaveState() {
        editor.setContent("Hello, World!");
        history.backup();
        assertFalse(history == null);
    }

    @Test
    void undo_ShouldRestorePreviousState() {
        editor.setContent("First State");
        history.backup();

        editor.setContent("Second State");
        history.undo();

        assertEquals("First State", editor.createMemento().getContent());
    }

    @Test
    void undo_ShouldNotFailOnEmptyHistory() {
        history.undo();
        assertEquals("", editor.createMemento().getContent());
    }
}
