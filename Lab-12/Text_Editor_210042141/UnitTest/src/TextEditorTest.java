import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextEditorTest
{

    private TextEditor editor;

    @BeforeEach
    public void setUp()
    {
        editor = new TextEditor();
    }

    @Test
    public void testSetContent_ShouldUpdateContent()
    {
        editor.setContent("Hello, World!");
        assertEquals("Hello, World!", editor.createMemento().getContent(), "The content should be 'Hello, World!'");
    }

    @Test
    public void testSetCursorPosition_ShouldUpdatePosition()
    {
        editor.setCursorPosition(5);
        assertEquals(5, editor.createMemento().getCursorPosition(), "The cursor position should be 5");
    }

    @Test
    public void testAddSelection_ShouldAddToSelections()
    {
        editor.addSelection("Hello");
        assertTrue(editor.createMemento().getSelections().contains("Hello"), "The selection 'Hello' should be added");
    }

    @Test
    public void testClearSelections_ShouldClearSelections()
    {
        editor.addSelection("Hello");
        editor.clearSelections();
        assertTrue(editor.createMemento().getSelections().isEmpty(), "Selections should be cleared");
    }

    @Test
    public void testDisplayState_ShouldDisplayCurrentState()
    {
        editor.setContent("Test content");
        editor.setCursorPosition(5);
        editor.addSelection("Test");
        editor.displayState();
    }
}
