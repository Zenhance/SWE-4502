import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    @Test
    public void testSetContent() {
        TextEditor editor = new TextEditor();
        editor.setContent("Hello World");
        assertEquals("Hello World", editor.createMemento().getContent(), "Content should be correctly stored in memento.");
    }

    @Test
    public void testSetCursorPosition() {
        TextEditor editor = new TextEditor();
        editor.setContent("Hello World");
        editor.setCursorPosition(6);
        assertEquals(6, editor.createMemento().getCursorPosition(), "Cursor position should be correctly stored in memento.");
    }

    @Test
    public void testAddSelection() {
        TextEditor editor = new TextEditor();
        editor.setContent("Hello World");
        editor.addSelection("Hello");
        assertEquals(List.of("Hello"), editor.createMemento().getSelections(), "Selected text should be correctly stored in memento.");
    }

    @Test
    public void testClearSelections() {
        TextEditor editor = new TextEditor();
        editor.setContent("Hello World");
        editor.addSelection("Hello");
        editor.clearSelections();
        assertEquals(0, editor.createMemento().getSelections().size(), "Selections should be cleared.");
    }

    @Test
    public void testRestoreFromMemento() {
        TextEditor editor = new TextEditor();
        editor.setContent("Version 1");
        editor.setCursorPosition(4);
        editor.addSelection("Ver");

        EditorMemento memento = editor.createMemento();

        editor.setContent("Changed Content");
        editor.setCursorPosition(10);
        editor.addSelection("Changed");

        editor.restoreFromMemento(memento);

        assertEquals("Version 1", editor.createMemento().getContent(), "Editor should restore previous content.");
        assertEquals(4, editor.createMemento().getCursorPosition(), "Editor should restore previous cursor position.");
        assertEquals(List.of("Ver"), editor.createMemento().getSelections(), "Editor should restore previous selections.");
    }

}