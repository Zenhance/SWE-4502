using Text_Editor_Project.Core;
using System;
using System.IO;
using System.Collections.Generic;
using Xunit;
namespace Text_Editor_Project_test
{
    public class UnitTest1
    {
        [Fact]
        public void SetContent_ShouldUpdateContent()
        {
            // Arrange
            var editor = new TextEditor();
            string expectedContent = "Hello, world!";
            
            // Act
            editor.SetContent(expectedContent);
            var memento = editor.CreateMemento();
            
            // Assert: Content is updated, cursor is reset and selections are cleared.
            Assert.Equal(expectedContent, memento.Content);
            Assert.Equal(0, memento.CursorPosition);
            Assert.Empty(memento.Selections);
        }
        
        [Fact]
        public void SetCursorPosition_ValidPosition_ShouldUpdatePosition()
        {
            // Arrange
            var editor = new TextEditor();
            string content = "Hello, world!";
            editor.SetContent(content);
            int validPosition = 5;
            
            // Act
            editor.SetCursorPosition(validPosition);
            var memento = editor.CreateMemento();
            
            // Assert: The cursor position is updated.
            Assert.Equal(validPosition, memento.CursorPosition);
        }
        
        [Fact]
        public void AddSelection_ShouldAddToSelections()
        {
            // Arrange
            var editor = new TextEditor();
            string selection = "selected text";
            
            // Act
            editor.AddSelection(selection);
            var memento = editor.CreateMemento();
            
            // Assert: The selection is added.
            Assert.Contains(selection, memento.Selections);
        }
        
        [Fact]
        public void ClearSelections_ShouldRemoveAllSelections()
        {
            // Arrange
            var editor = new TextEditor();
            editor.AddSelection("sel1");
            editor.AddSelection("sel2");
            
            // Act
            editor.ClearSelections();
            var memento = editor.CreateMemento();
            
            // Assert: All selections are removed.
            Assert.Empty(memento.Selections);
        }
    }
    
    public class HistoryUnitTests
    {
        [Fact]
        public void SaveAndLoadState_ShouldPreserveEditorState()
        {
            // Arrange
            var editor = new TextEditor();
            string initialContent = "Test Content";
            editor.SetContent(initialContent);
            int initialCursor = 4;
            editor.SetCursorPosition(initialCursor);
            string initialSelection = "selection1";
            editor.AddSelection(initialSelection);
            
            var history = new History(editor);
            // Ensure the history list is initialized.
            if (history.editorMementos == null)
                history.editorMementos = new List<EditorMemento>();
            
            // Backup current state and save to a temporary file.
            history.Backup();
            string tempFile = Path.GetTempFileName();
            history.SaveToFile(tempFile);
            
            // Change the editor state.
            editor.SetContent("Modified Content");
            editor.SetCursorPosition(2);
            editor.ClearSelections();
            
            // Act: Load the saved state and perform an Undo to restore.
            history.LoadFromFile(tempFile);
            history.Undo();
            var memento = editor.CreateMemento();
            
            // Assert: The editor state is restored to the original backup.
            Assert.Equal(initialContent, memento.Content);
            Assert.Equal(initialCursor, memento.CursorPosition);
            Assert.Contains(initialSelection, memento.Selections);
            
            // Cleanup the temporary file.
            File.Delete(tempFile);
        }
        
        [Fact]
        public void Undo_ShouldRestorePreviousState()
        {
            // Arrange
            var editor = new TextEditor();
            string initialContent = "Initial Content";
            editor.SetContent(initialContent);
            int initialCursor = 7;
            editor.SetCursorPosition(initialCursor);
            string initialSelection = "sel1";
            editor.AddSelection(initialSelection);
            
            var history = new History(editor);
            if (history.editorMementos == null)
                history.editorMementos = new List<EditorMemento>();
            
            // Create a backup of the initial state.
            history.Backup();
            
            // Modify the editor state.
            editor.SetContent("Modified Content");
            editor.SetCursorPosition(2);
            editor.ClearSelections();
            
            // Act: Perform an Undo to revert to the initial state.
            history.Undo();
            var memento = editor.CreateMemento();
            
            // Assert: The state after undo should match the initial state.
            Assert.Equal(initialContent, memento.Content);
            Assert.Equal(initialCursor, memento.CursorPosition);
            Assert.Contains(initialSelection, memento.Selections);
        }
    }
}