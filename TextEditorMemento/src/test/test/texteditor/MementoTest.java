package texteditor;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MementoTest {

    @Test
    void memento_ShouldCaptureStateCorrectly() {
        TextEditor editor = new TextEditor();
        editor.setContent("Test");
        editor.setCursorPosition(2);
        editor.addSelection("word");

        EditorMemento memento = editor.createMemento();
        assertEquals("Test", memento.getContent());
        assertEquals(2, memento.getCursorPosition());
        assertEquals(List.of("word"), memento.getSelections());
    }

    @Test
    void restoreFromMemento_ShouldRestoreCorrectState() {
        TextEditor editor = new TextEditor();
        editor.setContent("A");
        editor.setCursorPosition(1);
        editor.addSelection("select");

        EditorMemento memento = editor.createMemento();

        editor.setContent("B");
        editor.setCursorPosition(0);
        editor.clearSelections();

        editor.restoreFromMemento(memento);
        assertEquals("A", editor.getContent());
        assertEquals(1, editor.getCursorPosition());
        assertEquals(List.of("select"), editor.getSelections());
    }
}
