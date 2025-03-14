package UnitTest;


import Editor.TextEditor;
import Editor.EditorMemento;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class EditorMementoTest {

    @Test
    public void testMementoStoresState() {
        TextEditor editor = new TextEditor();
        editor.setContent("Hello");
        editor.setCursorPosition(2);
        editor.addSelection("Hello");

        EditorMemento memento = editor.createMemento();

        assertEquals("Hello", memento.getContent());
        assertEquals(2, memento.getCursorPosition());
        assertEquals(List.of("Hello"), memento.getSelections());
    }

    @Test
    public void testRestoreFromMemento() {
        TextEditor editor = new TextEditor();
        editor.setContent("Hello");
        editor.setCursorPosition(2);
        editor.addSelection("Hello");

        EditorMemento memento = editor.createMemento();

        editor.setContent("New Content");
        editor.setCursorPosition(5);
        editor.clearSelections();

        editor.restoreFromMemento(memento);

        assertEquals("Hello", editor.getContent());
        assertEquals(2, editor.getCursorPosition());
        assertEquals(List.of("Hello"), editor.getSelections());
    }
}
