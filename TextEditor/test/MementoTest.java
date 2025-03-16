import textEditor.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MementoTest {
    private TextEditor editor;

    @BeforeEach
    public void setUp() {
        editor = new TextEditor();
    }

    @Test
    public void testCreateMemento() {
        editor.setContent("Good lab task indeed");
        editor.setCursorPosition(19);
        editor.addSelection("task");

        EditorMemento memento = editor.createMemento();

        assertEquals("Good lab task indeed", memento.getContent());
        assertEquals(19, memento.getCursorPosition());
        assertEquals("task", memento.getSelection());
    }

    @Test
    public void testRestoreMemento() {
        editor.setContent("Good lab task indeed");
        editor.setCursorPosition(19);
        editor.addSelection("task");

        EditorMemento memento = editor.createMemento();

        assertEquals("Good lab task indeed", editor.getContent());
        assertEquals(19, editor.getCursorPosition());
        assertEquals("task", editor.getSelection());


        editor.setContent("Impressive lab task indeed");
        editor.setCursorPosition(12);
        editor.addSelection("lab");

        assertEquals("Impressive lab task indeed", editor.getContent());
        assertEquals(12, editor.getCursorPosition());
        assertEquals("lab", editor.getSelection());

        editor.restoreFromMemento(memento);

        assertEquals("Good lab task indeed", editor.getContent());
        assertEquals(19, editor.getCursorPosition());
        assertEquals("task", editor.getSelection());


    }


}
