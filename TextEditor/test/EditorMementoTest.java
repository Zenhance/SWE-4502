import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EditorMementoTest {

    @Test
    void testEditorMementoConstructor() {
        String content = "Test Content";
        int cursorPosition = 5;
        List<String> selections = List.of("Selection1", "Selection2");

        EditorMemento memento = new EditorMemento(content, cursorPosition, selections);

        assertEquals(content, memento.getContent());
        assertEquals(cursorPosition, memento.getCursorPosition());
        assertEquals(selections, memento.getSelections());
    }

    @Test
    void testEditorMementoDefaultConstructor() {
        EditorMemento memento = new EditorMemento();
        assertNotNull(memento);
    }
}
