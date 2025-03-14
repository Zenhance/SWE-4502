import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextEditorTest {

    @Test
    public void testSetContent() {
        TextEditor editor = new TextEditor();
        editor.setContent("Hello, World!");
        assertEquals("Hello, World!", editor.getContent());
    }

    @Test
    public void testUndo() {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.setContent("First Edit");
        history.backup(editor);

        editor.setContent("Second Edit");
        history.undo(editor);

        assertEquals("First Edit", editor.getContent());
    }
}
