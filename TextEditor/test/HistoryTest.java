import textEditor.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HistoryTest {
    private TextEditor editor;
    private History history;

    @BeforeEach
    public void setUp() {
        editor = new TextEditor();
        history = new History(editor);
    }

    @Test
    public void testBackupMethod() {
        editor.setContent("Good lab task indeed");
        editor.setCursorPosition(19);
        editor.addSelection("task");
        history.backup();

        assertEquals(1, history.getMementos().size());
    }

    @Test
    public void undo_ShouldRestorePreviousState() {
        editor.setContent("Good lab task indeed");
        editor.setCursorPosition(19);
        editor.addSelection("task");
        history.backup();

        editor.setContent("Impressive lab task indeed");
        history.backup();


        assertEquals("Impressive lab task indeed", editor.getContent());
        assertEquals(19, editor.getCursorPosition());
        assertEquals("task", editor.getSelection());

        history.undo();

        assertEquals("Good lab task indeed", editor.getContent());
        assertEquals(19, editor.getCursorPosition());
        assertEquals("task", editor.getSelection());
    }

    @Test
    public void undo_ThrowErrorWhenThereIsNoState() {
        editor.setContent("Good lab task indeed");
        history.backup();
        editor.setContent("Impressive lab task indeed!");
        history.backup();

        history.undo();
        history.undo();
        history.undo();


        assertEquals(0, history.getCount());
    }
}
