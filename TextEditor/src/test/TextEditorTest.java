package test;
import main.EditorMemento;
import main.History;
import main.TextEditor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextEditorTest {
    private TextEditor editor;
    @BeforeEach
    void setUp(){
        editor= new TextEditor();
    }
    @Test
    void UpdateContent(){
        editor.setContent("hello");
        assertEquals("bye bye world",editor.getContent());
    }
    @Test
    void SaveState()
    {
        History history=new History(editor);
        editor.setContent("Saved");
        history.save();
        assertFalse(history.isEmpty());
    }



}
