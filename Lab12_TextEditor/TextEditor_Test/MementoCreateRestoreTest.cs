using Lab12_TextEditor;

namespace TestProject1;

public class MementoCreateRestoreTest
{
    [Fact]
    public void CreateMementoTest()
    {
        Editor editor = new Editor();
        editor.Insert("Hello World!");
        editor.SetCursorPosition(6);
        editor.Select(6, 6);
        
        EditorMemento memento = editor.CreateMemento();
        
        Assert.Equal("Hello World!", memento.GetText());
        Assert.Equal(6, memento.GetCursorPosition());
        Assert.Equal("World!", memento.GetSelection());
    }

    [Fact]
    public void RestoreMementoTest()
    {
        Editor editor = new Editor();
        editor.Insert("Hello World!");
        editor.SetCursorPosition(6);
        editor.Select(6, 6);
        
        EditorMemento memento = editor.CreateMemento();
        
        editor.Select(4, 8);
        Assert.Equal("o World!", editor.GetSelection());
        
        editor.Restore(memento);
        Assert.Equal("World!", editor.GetSelection());
    }
}