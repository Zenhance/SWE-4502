import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextEditorTests
{
    private TextEditor editor;
    private History history;

    @BeforeEach
    void setUp() {
        editor = new TextEditor();
        history = new History(editor);
    }

    @Test
    void setContent_ShouldUpdateContent() {
        // Arrange
        String expected = "Hello, World!";

        // Act
        editor.setContent(expected);

        // Assert
        assertEquals(expected, editor.getContent());
    }

    @Test
    void setCursorPosition_ValidPosition_ShouldUpdatePosition() {
        // Arrange
        editor.setContent("Hello");
        int expected = 3;

        // Act
        editor.setCursorPosition(expected);

        // Assert
        assertEquals(expected, editor.getCursorPosition());
    }

    @Test
    void setCursorPosition_NegativePosition_ShouldSetToZero() {
        // Arrange
        editor.setContent("Hello");

        // Act
        editor.setCursorPosition(-5);

        // Assert
        assertEquals(0, editor.getCursorPosition());
    }

    @Test
    void setCursorPosition_BeyondContent_ShouldSetToContentLength() {
        // Arrange
        String content = "Hello";
        editor.setContent(content);

        // Act
        editor.setCursorPosition(100);

        // Assert
        assertEquals(content.length(), editor.getCursorPosition());
    }

    @Test
    void addSelection_ShouldAddToSelections() {
        // Arrange
        String selection = "test selection";

        // Act
        editor.addSelection(selection);

        // Assert
        List<String> selections = editor.getSelections();
        assertEquals(1, selections.size());
        assertEquals(selection, selections.get(0));
    }

    @Test
    void clearSelections_ShouldRemoveAllSelections() {
        // Arrange
        editor.addSelection("selection 1");
        editor.addSelection("selection 2");

        // Act
        editor.clearSelections();

        // Assert
        assertTrue(editor.getSelections().isEmpty());
    }

    @Test
    void createMemento_ShouldCaptureCurrentState() {
        // Arrange
        String content = "Test Content";
        int position = 4;
        List<String> selections = Arrays.asList("Selection 1", "Selection 2");

        editor.setContent(content);
        editor.setCursorPosition(position);
        for (String selection : selections) {
            editor.addSelection(selection);
        }

        // Act
        EditorMemento memento = editor.createMemento();

        // Assert
        assertEquals(content, memento.getContent());
        assertEquals(position, memento.getCursorPosition());
        assertEquals(selections.size(), memento.getSelections().size());
        for (int i = 0; i < selections.size(); i++) {
            assertEquals(selections.get(i), memento.getSelections().get(i));
        }
    }

    @Test
    void restoreFromMemento_ShouldRestoreState() {
        // Arrange
        String originalContent = "Original";
        String newContent = "New Content";

        editor.setContent(originalContent);
        EditorMemento memento = editor.createMemento();

        // Change the state
        editor.setContent(newContent);

        // Act
        editor.restoreFromMemento(memento);

        // Assert
        assertEquals(originalContent, editor.getContent());
    }

    @Test
    void history_backup_ShouldSaveState() {
        // Arrange
        editor.setContent("Initial content");

        // Act
        history.backup();
        editor.setContent("Modified content");
        history.undo();

        // Assert
        assertEquals("Initial content", editor.getContent());
    }

    @Test
    void history_undo_WithEmptyHistory_ShouldDoNothing() {
        // Arrange
        editor.setContent("Test content");

        // Act & Assert (should not throw exception)
        history.undo();

        // State should remain unchanged
        assertEquals("Test content", editor.getContent());
    }
}
