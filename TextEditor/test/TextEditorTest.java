import textEditor.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextEditorTest {
    private TextEditor editor;

    @BeforeEach
    public void setUp() {
        editor = new TextEditor();
    }

    @Test
    public void setContent_ShouldUpdateContent() {
        editor.setContent("Good lab task indeed");
        assertEquals("Good lab task indeed", editor.getContent());
    }

    @Test
    public void setCursorPosition_ValidPosition_ShouldUpdatePosition() {
        editor.setContent("Good lab task indeed");
        editor.setCursorPosition(19);
        assertEquals(19, editor.getCursorPosition());
    }

    @Test
    public void setCursorPosition_InvalidPosition_ShouldNotUpdatePosition() {
        editor.setContent("Good lab task indeed");
        editor.setCursorPosition(21);
        assertEquals(0, editor.getCursorPosition());
    }


    @Test
    public void addSelection_ShouldAddToSelections() {
        editor.addSelection("task");
        assertEquals("task", editor.getSelection());
    }

    @Test
    public void clearSelections_ShouldRemoveAllSelections() {
        editor.addSelection("task");
        editor.clearSelections();
        assertEquals("", editor.getSelection());
    }
}
