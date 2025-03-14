import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.List;

public class UnitTest {

    private TextEditor editor;
    private History history;

    @BeforeEach
    public void setUp() {
        // Initialize the TextEditor and History objects before each test
        editor = new TextEditor();
        history = new History();
    }

    // Test 1: SetContent_ShouldUpdateContent
    @Test
    public void SetContent_ShouldUpdateContent() {
        editor.setContent("Hello, World!");
        assertEquals("Hello, World!", editor.getContent(), "Content should be updated");
    }

    // Test 2: SetCursorPosition_ValidPosition_ShouldUpdatePosition
    @Test
    public void SetCursorPosition_ValidPosition_ShouldUpdatePosition() {
        editor.setCursorPosition(5);
        assertEquals(5, editor.getCursorPosition(), "Cursor position should be updated");
    }

    // Test 3: AddSelection_ShouldAddToSelections
    @Test
    public void AddSelection_ShouldAddToSelections() {
        editor.addSelection("Hello");
        assertEquals("Hello", editor.getSelection(), "Selection should be added");
    }

    // Test 4: ClearSelections_ShouldRemoveAllSelections
    @Test
    public void ClearSelections_ShouldRemoveAllSelections() {
        editor.addSelection("Hello");
        editor.clearSelections();
        assertEquals("", editor.getSelection(), "Selections should be cleared");
    }

    // Test 5: SaveAndLoadState_ShouldPreserveEditorState
    @Test
    public void SaveAndLoadState_ShouldPreserveEditorState() {
        editor.setContent("Initial Content");
        editor.setCursorPosition(10);
        editor.addSelection("Some Text");

        // Save the state to a file
        FilePersistence.saveToFile("history.dat", history.history);

        // Modify the editor
        editor.setContent("Modified Content");
        editor.setCursorPosition(20);
        editor.addSelection("Modified Text");

        // Load the state from the file
        List<EditorMemento> loadedHistory = FilePersistence.loadFromFile("history.dat");

        // Assert that the state is preserved after loading
        assertNotNull(loadedHistory, "Loaded history should not be null");
        assertEquals("Initial Content", loadedHistory.get(0).getContent(), "Content should be preserved");
        assertEquals(10, loadedHistory.get(0).getCursorPosition(), "Cursor position should be preserved");
        assertEquals("Some Text", loadedHistory.get(0).getSelection(), "Selection should be preserved");
    }

    // Test 6: Undo_ShouldRestorePreviousState
    @Test
    public void Undo_ShouldRestorePreviousState() {
        editor.setContent("Initial Content");
        editor.setCursorPosition(5);
        editor.addSelection("Hello");
        history.backup(editor.createMemento());

        // Modify the editor
        editor.setContent("Modified Content");
        editor.setCursorPosition(10);
        editor.addSelection("World");
        history.backup(editor.createMemento());

        // Perform undo
        history.undo();
        editor.restoreFromMemento(history.getCurrentMemento());

        // Assert that the editor's state has been restored to the previous state
        assertEquals("Initial Content", editor.getContent(), "Content should be restored after undo");
        assertEquals(5, editor.getCursorPosition(), "Cursor position should be restored after undo");
        assertEquals("Hello", editor.getSelection(), "Selection should be restored after undo");
    }
}
