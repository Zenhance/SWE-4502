package UnitTest;

import Editor.TextEditor;
import org.junit.Test;


import static org.junit.Assert.*;

public class TextEditorTest {
    @Test
    public void testEditorInitialization() {
        TextEditor editor = new TextEditor();
        assertNotNull("Editor should be initialized successfully.", editor);
    }

}