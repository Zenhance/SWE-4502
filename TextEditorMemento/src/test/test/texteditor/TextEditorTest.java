package texteditor;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextEditorTest {

    @Test
    void setContent_ShouldUpdateContent() {
        TextEditor editor = new TextEditor();
        editor.setContent("Hello");
        assertEquals("Hello", editor.getContent());
    }

    @Test
    void setCursorPosition_ValidPosition_ShouldUpdatePosition() {
        TextEditor editor = new TextEditor();
        editor.setContent("Hello");
        editor.setCursorPosition(2);
        assertEquals(2, editor.getCursorPosition());
    }

    @Test
    void setCursorPosition_InvalidPosition_ShouldNotChange() {
        TextEditor editor = new TextEditor();
        editor.setContent("Hello");
        editor.setCursorPosition(10);  // Invalid
        assertEquals(0, editor.getCursorPosition());  // Default
    }

    @Test
    void addSelection_ShouldAddToSelections() {
        TextEditor editor = new TextEditor();
        editor.addSelection("text");
        assertTrue(editor.getSelections().contains("text"));
    }

    @Test
    void clearSelections_ShouldRemoveAllSelections() {
        TextEditor editor = new TextEditor();
        editor.addSelection("text");
        editor.clearSelections();
        assertTrue(editor.getSelections().isEmpty());
    }
}
