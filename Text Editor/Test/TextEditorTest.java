import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import texteditor.TextEditor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TextEditorTest {
    private TextEditor editor;

    @BeforeEach
    void setUp() {
        editor = new TextEditor();
    }

    @Test
    void setContent_ShouldUpdateContent() {
        editor.setContent("Hello, World!");
        assertEquals("Hello, World!", editor.createMemento().getContent());
    }

    @Test
    void setCursorPosition_ValidPosition_ShouldUpdatePosition() {
        editor.setContent("Hello");
        editor.setCursorPosition(3);
        assertEquals(3, editor.createMemento().getCursorPosition());
    }

    @Test
    void setCursorPosition_InvalidPosition_ShouldNotUpdate() {
        editor.setContent("Hello");
        editor.setCursorPosition(10);
        assertNotEquals(10, editor.createMemento().getCursorPosition());
    }

    @Test
    void addSelection_ShouldAddToSelections() {
        editor.addSelection("World");
        List<String> selections = editor.createMemento().getSelections();
        assertTrue(selections.contains("World"));
    }

    @Test
    void clearSelections_ShouldRemoveAllSelections() {
        editor.addSelection("Test");
        editor.clearSelections();
        assertEquals(0, editor.createMemento().getSelections().size());
    }
}
