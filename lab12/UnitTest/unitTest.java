
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class unitTest {

    private TextEditor editor;
    private History history;

    @BeforeEach
    public void setup() {
        editor = new TextEditor();
        history = new History(editor);
    }

    @Test
    public void setContent_ShouldUpdateContent() {

        String content = "Hello, World!";


        editor.setContent(content);

        assertEquals(content, editor.getContent());
    }


    @Test
    public void setCursorPosition_ValidPosition_ShouldUpdatePosition() {

        int position = 5;

        editor.setPosition(position);

        assertEquals(position, editor.getPosition());
    }



}
