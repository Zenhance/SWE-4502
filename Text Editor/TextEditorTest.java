package texteditor;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TextEditorTest {
    
    private TextEditor editor;
    
    @Before
    public void setUp() {
        editor = new TextEditor();
    }
    
    /**
     * Test case: SetContent_ShouldUpdateContent
     * Verifies that the setContent method correctly updates the editor's content
     */
    @Test
    public void testSetContent_ShouldUpdateContent() {
        // Arrange
        String expectedContent = "Test Content";
        
        // Act
        editor.setContent(expectedContent);
        EditorMemento memento = editor.createMemento();
        
        // Assert
        assertEquals("Content should be updated correctly", expectedContent, memento.getContent());
    }
    
    /**
     * Test case: Undo_ShouldRestorePreviousState
     * Verifies that the undo operation correctly restores the previous state
     */
    @Test
    public void testUndo_ShouldRestorePreviousState() {
        // Arrange
        String initialContent = "Initial Content";
        String modifiedContent = "Modified Content";
        editor.setContent(initialContent);
        
        // Create history and save initial state
        History history = new History(editor);
        history.backup();
        
        // Act - modify content and then undo
        editor.setContent(modifiedContent);
        history.undo();
        
        // Assert
        EditorMemento currentState = editor.createMemento();
        assertEquals("Content should be restored to initial state", initialContent, currentState.getContent());
    }
} 