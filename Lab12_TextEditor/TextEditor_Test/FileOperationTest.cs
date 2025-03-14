using Lab12_TextEditor;

namespace TestProject1;

public class FileOperationTest
{
    [Fact]
    public void SaveFileTest()
    {
        Editor editor = new Editor();
        editor.Insert("Hello World!");
        editor.SetCursorPosition(10);
        
        Assert.Equal(10, editor.GetCursorPosition());

        History history = new History(editor);
        history.Backup();
        
        history.SaveToJson("F:\\iut\\5th_Sem_labs\\DP_REPO\\Lab12_TextEditor\\TestFiles\\test.json");
        
        editor.SetCursorPosition(2);
        
        history.LoadFromJson("F:\\iut\\5th_Sem_labs\\DP_REPO\\Lab12_TextEditor\\TestFiles\\test.json");
        
        Assert.Equal("Hello World!", editor.GetText());
        Assert.Equal(10, editor.GetCursorPosition());
        
    }
}