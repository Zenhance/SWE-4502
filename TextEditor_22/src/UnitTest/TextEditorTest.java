package UnitTest;

import Editor.TextEditor;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.*;

public class TextEditorTest {
    @Test
    public void testSetContent(){
        TextEditor editor = new TextEditor();
        editor.setContent("Tasnim");
        assertEquals("Tasnim",editor.getContent());
        assertEquals(6, editor.getCursorPosition());
    }

    @Test
    public void testSetCursorPosition_Valid() {
        TextEditor editor = new TextEditor();
        editor.setContent("Hello");
        editor.setCursorPosition(3);
        assertEquals(3, editor.getCursorPosition());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCursorPosition_Invalid() {
        TextEditor editor = new TextEditor();
        editor.setContent("Hello");
        editor.setCursorPosition(10); // Invalid position
    }

    @Test
    public void testAddSelection() {
        TextEditor editor = new TextEditor();
        editor.addSelection("Hello");
        List<String> selections = editor.getSelections();
        assertEquals(1, selections.size());
        assertEquals("Hello", selections.get(0));
    }

    @Test
    public void testClearSelections() {
        TextEditor editor = new TextEditor();
        editor.addSelection("Test");
        editor.clearSelections();
        assertTrue(editor.getSelections().isEmpty());
    }


}