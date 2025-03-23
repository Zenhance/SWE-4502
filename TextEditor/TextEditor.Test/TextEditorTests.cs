using Xunit;
using System.IO;
using TextEditor;

namespace TextEditor.Test;

public class TextEditorTests
{
    private readonly TextEditor _editor;
    private readonly History _history;
    private readonly string _testFilePath = "test_state.json";

    public TextEditorTests()
    {
        _editor = new TextEditor();
        _history = new History(_editor);
    }

    [Fact]
    public void SetContent_ShouldUpdateContent()
    {
        // Arrange
        string expectedContent = "Hello, World!";

        // Act
        _editor.SetContent(expectedContent);
        var memento = _editor.CreateMemento();

        // Assert
        Assert.Equal(expectedContent, memento.Content);
    }

    [Fact]
    public void SetCursorPosition_ValidPosition_ShouldUpdatePosition()
    {
        // Arrange
        _editor.SetContent("Hello");
        int expectedPosition = 3;

        // Act
        _editor.SetCursorPosition(expectedPosition);
        var memento = _editor.CreateMemento();

        // Assert
        Assert.Equal(expectedPosition, memento.CursorPosition);
    }

    [Fact]
    public void AddSelection_ShouldAddToSelections()
    {
        // Arrange
        string selection = "test selection";

        // Act
        _editor.AddSelection(selection);
        var memento = _editor.CreateMemento();

        // Assert
        Assert.Contains(selection, memento.Selections);
    }

    [Fact]
    public void ClearSelections_ShouldRemoveAllSelections()
    {
        // Arrange
        _editor.AddSelection("selection 1");
        _editor.AddSelection("selection 2");

        // Act
        _editor.ClearSelections();
        var memento = _editor.CreateMemento();

        // Assert
        Assert.Empty(memento.Selections);
    }

    [Fact]
    public void SaveAndLoadState_ShouldPreserveEditorState()
    {
        // Arrange
        string content = "Test content";
        int cursorPosition = 5;
        string selection = "test selection";

        _editor.SetContent(content);
        _editor.SetCursorPosition(cursorPosition);
        _editor.AddSelection(selection);

        // Act
        _history.SaveToFile(_testFilePath);
        
        // Clear the current state
        _editor.SetContent("");
        _editor.SetCursorPosition(0);
        _editor.ClearSelections();

        // Load the saved state
        _history.LoadFromFile(_testFilePath);
        var restoredMemento = _editor.CreateMemento();

        // Assert
        Assert.Equal(content, restoredMemento.Content);
        Assert.Equal(cursorPosition, restoredMemento.CursorPosition);
        Assert.Contains(selection, restoredMemento.Selections);

        // Cleanup
        if (File.Exists(_testFilePath))
        {
            File.Delete(_testFilePath);
        }
    }

    [Fact]
    public void Undo_ShouldRestorePreviousState()
    {
        // Arrange
        string initialContent = "Initial content";
        string updatedContent = "Updated content";

        // Act
        _editor.SetContent(initialContent);
        _history.Backup();
        _editor.SetContent(updatedContent);
        _history.Undo();

        var memento = _editor.CreateMemento();

        // Assert
        Assert.Equal(initialContent, memento.Content);
    }
} 