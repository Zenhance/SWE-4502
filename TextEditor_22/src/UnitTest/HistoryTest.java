package UnitTest;


import Editor.*;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class HistoryTest {

    @Test
    public void testBackupAndUndo() {
        TextEditor editor = new TextEditor();
        History history = new History(editor);

        editor.setContent("First Edit");
        editor.setCursorPosition(10);
        editor.addSelection("First Selection");

        // Backup the state
        history.backup();

        editor.setContent("Second Edit");
        editor.setCursorPosition(5);
        editor.clearSelections();

        // Backup the new state
        history.backup();

        // Undo to the previous state
        history.undo();

        // Assert that the state is restored correctly
        assertEquals("First Edit", editor.getContent());
        assertEquals(10, editor.getCursorPosition());
        assertEquals(List.of("First Selection"), editor.getSelections());


    }

    @Test
    public void testCanUndo() {
        TextEditor editor = new TextEditor();
        History history = new History(editor);

        editor.setContent("Initial Edit");
        history.backup();

        assertTrue(history.canUndo());

        history.undo();
        assertFalse(history.canUndo());
    }
}
