import org.example.State;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HistoryTest {

    @Test
    void saveState() {
        History history = new History();
        TextEditor textEditor = new TextEditor("Hello", 0, 0);
        Memento memento = textEditor.save();

        history.saveState(memento);

        assertFalse(history.history.isEmpty());
        assertEquals(memento, history.history.peek());
    }

    @Test
    void saveMultipleStates() {
        History history = new History();
        TextEditor textEditor = new TextEditor("Hello", 0, 0);

        Memento memento1 = textEditor.save();
        history.saveState(memento1);

        textEditor.write(" World");
        Memento memento2 = textEditor.save();
        history.saveState(memento2);

        assertEquals(2, history.history.size());
        assertEquals(memento2, history.history.peek());
    }

    @Test
    void undoEmptyHistory() {
        History history = new History();
        TextEditor textEditor = new TextEditor("Hello", 0, 0);

        textEditor.save();


        history.undo(textEditor);
        Memento memento = textEditor.save();
        history.saveState(memento);
        Memento memento2 = textEditor.save();
        textEditor.write(" World");
        history.saveState(memento2);
        history.undo(textEditor);

        assertEquals("Hello", textEditor.getText());
        assertEquals(0, textEditor.getCursorPosition_X());
        assertEquals(0, textEditor.getCursorPosition_Y());
    }

    @Test
    void undoSingleState() {
        History history = new History();
        TextEditor textEditor = new TextEditor("Hello", 0, 0);

        Memento initialState = textEditor.save();
        history.saveState(initialState);

        textEditor.write(" World");
        textEditor.moveCursor(5, 1);

        history.undo(textEditor);

        assertEquals("Hello", textEditor.getText());
        assertEquals(0, textEditor.getCursorPosition_X());
        assertEquals(0, textEditor.getCursorPosition_Y());
        assertTrue(history.history.isEmpty());
    }

    @Test
    void undoMultipleStates() {
        History history = new History();
        TextEditor textEditor = new TextEditor("", 0, 0);

        // Initial state
        Memento state1 = textEditor.save();
        history.saveState(state1);

        // First modification
        textEditor.write("Hello");
        textEditor.moveCursor(5, 0);
        Memento state2 = textEditor.save();
        history.saveState(state2);

        // Second modification
        textEditor.write(" World");
        textEditor.moveCursor(11, 0);
        Memento state3 = textEditor.save();
        history.saveState(state3);

        // First undo should revert to "Hello"
        history.undo(textEditor);
        assertEquals("Hello", textEditor.getText());
        assertEquals(5, textEditor.getCursorPosition_X());
        assertEquals(0, textEditor.getCursorPosition_Y());

        // Second undo should revert to ""
        history.undo(textEditor);
        assertEquals("", textEditor.getText());
        assertEquals(0, textEditor.getCursorPosition_X());
        assertEquals(0, textEditor.getCursorPosition_Y());

        // History should be empty now
        assertTrue(history.history.isEmpty());
    }

    @Test
    void historySize() {
        History history = new History();
        TextEditor textEditor = new TextEditor("Initial", 0, 0);

        // Save multiple states
        for (int i = 0; i < 5; i++) {
            Memento state = textEditor.save();
            history.saveState(state);
            textEditor.write(" " + i);
        }

        assertEquals(5, history.history.size());

        // Undo all states
        for (int i = 0; i < 5; i++) {
            history.undo(textEditor);
        }

        assertEquals(0, history.history.size());
    }
}