package texteditor;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CursorPositionTest {
    
    private TextEditor editor;
    
    @Before
    public void setUp() {
        editor = new TextEditor();
        editor.setContent("Hello World");
    }
    
    /**
     * Test case: SetCursorPosition_ValidPosition_ShouldUpdatePosition
     * Verifies that setting a valid cursor position updates correctly
     */
    @Test
    public void testSetCursorPosition_ValidPosition_ShouldUpdatePosition() {
        // Arrange
        int expectedPosition = 5;
        
        // Act
        editor.setCursorPosition(expectedPosition);
        EditorMemento memento = editor.createMemento();
        
        // Assert
        assertEquals("Cursor position should be updated correctly", 
                     expectedPosition, memento.getCursorPosition());
    }
    
    /**
     * Test case: SetCursorPosition_InvalidPosition_ShouldClamp
     * Verifies that setting an invalid cursor position (negative or beyond content length)
     * results in the position being clamped to valid bounds
     */
    @Test
    public void testSetCursorPosition_InvalidPosition_ShouldClamp() {
        // Test negative position
        editor.setCursorPosition(-5);
        EditorMemento memento1 = editor.createMemento();
        assertEquals("Negative cursor position should be clamped to 0", 
                     0, memento1.getCursorPosition());
        
        // Test position beyond content length
        editor.setCursorPosition(100);
        EditorMemento memento2 = editor.createMemento();
        assertEquals("Cursor position beyond content length should be clamped to content length", 
                     "Hello World".length(), memento2.getCursorPosition());
    }
} 