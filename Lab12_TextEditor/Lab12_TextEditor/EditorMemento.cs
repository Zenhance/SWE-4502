namespace Lab12_TextEditor;

public class EditorMemento
{
    private readonly string _text;
    private readonly int _cursorPosition;
    private readonly string _selection;
    
    public EditorMemento(string text, int cursorPosition, string selection)
    {
        _text = text;
        _cursorPosition = cursorPosition;
        _selection = selection;
    }
    
    public string GetText()
    {
        return _text;
    }
    
    public int GetCursorPosition()
    {
        return _cursorPosition;
    }
    
    public string GetSelection()
    {
        return _selection;
    }
}