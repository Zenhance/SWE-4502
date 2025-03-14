using Lab12_TextEditor;

namespace TestProject1;

public class HistoryManagementTest
{
    [Fact]
    public void HistoryBackupTest()
    {
        Editor editor = new Editor();
        editor.Insert("Hello World!");
        editor.Select(6, 6);
        
        Assert.Equal("World!", editor.GetSelection());

        History history = new History(editor);
        history.Backup();

        EditorMemento em = history.GetLastMemento();
        
        Assert.Equal("World!", em.GetSelection());
    }


    [Fact]
    public void HistoryUndoTest()
    {
        Editor editor = new Editor();
        editor.Insert("Hello World!");
        editor.Select(6, 6);
        
        Assert.Equal("World!", editor.GetSelection());

        History history = new History(editor);
        history.Backup();
        
        editor.Select(3,5);
        Assert.Equal("lo Wo", editor.GetSelection());
        
        history.Undo();
        Assert.Equal("World!", editor.GetSelection());
    }
    
}