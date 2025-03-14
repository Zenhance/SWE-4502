using Xunit;
using TextEditorApp;

public class TextEditorTests
{
    [Fact]
    public void SetContent_ShouldUpdateContent()
    {
        TextEditor editor = new TextEditor();
        editor.SetContent("Test");

        Assert.Equal("Test", editor.CreateMemento().Content);
    }

    [Fact]
    public void Undo_ShouldRestorePreviousState()
    {
        TextEditor editor = new TextEditor();
        History history = new History(editor);

        editor.SetContent("First");
        history.Backup();
        editor.SetContent("Second");
        history.Backup();

        history.Undo();
        Assert.Equal("First", editor.CreateMemento().Content);
    }
}
