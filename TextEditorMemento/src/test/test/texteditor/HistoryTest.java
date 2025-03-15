package texteditor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoryTest {

    @Test
    void backupAndUndo_ShouldRestorePreviousState() {
        TextEditor editor = new TextEditor();
        History history = new History(editor);

        editor.setContent("First");
        editor.setCursorPosition(1);
        history.backup();

        editor.setContent("Second");
        editor.setCursorPosition(2);
        history.backup();

        history.undo();

        assertEquals("First", editor.getContent());
        assertEquals(1, editor.getCursorPosition());
    }

    @Test
    void undo_WithEmptyHistory_ShouldDoNothing() {
        TextEditor editor = new TextEditor();
        History history = new History(editor);

        editor.setContent("Hello");
        history.undo();  // Nothing backed up

        assertEquals("Hello", editor.getContent());  // Unchanged
    }
}
