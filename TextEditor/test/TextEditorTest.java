import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextEditorTest {
    private TextEditor editor;

    @BeforeEach
    void setUp() {
        editor = new TextEditor();
    }

    @Test
    void testSetContent() {
        String content = "Hello, World!";
        editor.setContent(content);
        editor.displayState();
        assertEquals(content, editor.createMemento().getContent());
    }

    @Test
    void testSetCursorPosition_ValidPosition() {
        editor.setContent("Hello");
        editor.setCursorPosition(3);
        assertEquals(3, editor.createMemento().getCursorPosition());
    }

    @Test
    void testSetCursorPosition_InvalidPosition() {
        editor.setContent("Hello");
        assertThrows(IllegalArgumentException.class, () -> editor.setCursorPosition(10));
    }

    @Test
    void testAddSelection() {
        editor.addSelection("Selection 1");
        assertTrue(editor.createMemento().getSelections().contains("Selection 1"));
    }

    @Test
    void testClearSelections() {
        editor.addSelection("Selection 1");
        editor.clearSelections();
        assertTrue(editor.createMemento().getSelections().isEmpty());
    }

    @Test
    void testCreateAndRestoreMemento() {
        editor.setContent("Hello");
        editor.setCursorPosition(5);
        editor.addSelection("Test Selection");

        EditorMemento memento = editor.createMemento();
        editor.setContent("New Content");
        editor.setCursorPosition(0);

        editor.restoreFromMemento(memento);
        assertEquals("Hello", editor.createMemento().getContent());
        assertEquals(5, editor.createMemento().getCursorPosition());
    }
}
