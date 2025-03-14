using Lab12_TextEditor;

namespace TestProject1;

public class BasicEditorTest
{
    [Fact]
    public void CreateEditor()
    {
        Editor editor = new Editor();
        Assert.NotNull(editor);
    }

    [Fact]
    public void InitialEditorValueTest()
    {
        Editor editor = new Editor();
        Assert.Equal("", editor.GetText());
        Assert.Equal(0, editor.GetCursorPosition());
        Assert.Equal("", editor.GetSelection());
    }


    [Fact]
    public void InsertTextToEditorTest()
    {
        string testString = "Hello World!";
        int actualCursorPosition = testString.Length;
        
        Editor editor = new Editor();
        editor.Insert(testString);
        
        Assert.Equal(testString, editor.GetText());
        Assert.Equal(actualCursorPosition, editor.GetCursorPosition());
    }
    
    [Fact]
    public void DeleteTextFromEditorTest()
    {
        string testString = "Hello World!";
        int deleteLength = 6;
        int cursorPosition = testString.Length - deleteLength;
        string expectedString = "Hello ";
        
        Editor editor = new Editor();
        editor.Insert(testString);
        editor.SetCursorPosition(cursorPosition);
        editor.Delete(deleteLength);
        
        Assert.Equal(expectedString, editor.GetText());
    }
    
    
    [Fact]
    public void SelectTextInEditorTest()
    {
        string testString = "Hello World!";
        int start = 6;
        int length = 6;
        string expectedSelection = "World!";
        
        Editor editor = new Editor();
        editor.Insert(testString);
        editor.Select(start, length);
        
        Assert.Equal(expectedSelection, editor.GetSelection());
    }
    
}