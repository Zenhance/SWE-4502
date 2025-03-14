namespace TextEditor;

public class EditorMemento
{
    public readonly string _text;
    public readonly int _cursorPosition;
    public readonly string _selection;
 
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