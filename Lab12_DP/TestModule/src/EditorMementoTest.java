import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class EditorMementoTest {

    @Test
    void testMementoStoresContent() {
        EditorMemento memento = new EditorMemento("Hello World", 5, Arrays.asList("Hello"));
        assertEquals("Hello World", memento.getContent(), "Memento should store the correct content.");
    }

    @Test
    void testMementoStoresCursorPosition() {
        EditorMemento memento = new EditorMemento("Hello World", 5, Arrays.asList("Hello"));
        assertEquals(5, memento.getCursorPosition(), "Memento should store the correct cursor position.");
    }

    @Test
    void testMementoStoresSelections() {
        EditorMemento memento = new EditorMemento("Hello World", 5, Arrays.asList("Hello", "World"));
        assertEquals(Arrays.asList("Hello", "World"), memento.getSelections(), "Memento should store selected text.");
    }
}
