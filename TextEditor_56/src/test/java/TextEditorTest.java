import org.example.State;

import static org.junit.jupiter.api.Assertions.*;

class TextEditorTest {

    @org.junit.jupiter.api.Test
    void write() {
        TextEditor textEditor = new TextEditor("Hello", 0, 0);
        assertEquals("Hello", textEditor.write("Hello"));
    }

    @org.junit.jupiter.api.Test
    void moveCursor() {
        TextEditor textEditor = new TextEditor("Hello", 0, 0);
        textEditor.moveCursor(1, 1);
        assertEquals(1, textEditor.getCursorPosition_X());
        assertEquals(1, textEditor.getCursorPosition_Y());
    }

    @org.junit.jupiter.api.Test
    void getText() {
        TextEditor textEditor = new TextEditor("hello", 0, 0);

        assertEquals("hello", textEditor.getText());
    }

    @org.junit.jupiter.api.Test
    void getCursorPosition_X() {
        TextEditor textEditor = new TextEditor("Hello", 5, 0);
        assertEquals(5, textEditor.getCursorPosition_X());
    }

    @org.junit.jupiter.api.Test
    void getCursorPosition_Y() {
        TextEditor textEditor = new TextEditor("Hello", 0, 0);
        assertEquals(0, textEditor.getCursorPosition_Y());
    }

    @org.junit.jupiter.api.Test
    void save() {
        TextEditor textEditor = new TextEditor("Hello", 0, 0);
        textEditor.write(" World");
        textEditor.moveCursor(4,2);
        Memento memento = textEditor.save();



        State savedState = memento.getState();
        textEditor.moveCursor(3,4);
        assertEquals("Hello World",savedState.getText());
        assertEquals(4,savedState.getCursorPosition_X());
        assertEquals(2,savedState.getCursorPosition_Y());

    }

    @org.junit.jupiter.api.Test
    void restore() {
        TextEditor textEditor = new TextEditor("Hello", 0, 0);
        Memento memento = textEditor.save();
        State state= memento.getState();
        textEditor.write(" World");
        textEditor.moveCursor(3, 4);
        textEditor.restore(memento);
        assertEquals("Hello", state.getText());
    }

}