namespace Lab12_TextEditor;

public class EditorMemento
{
    public string _text;
    public int _cursorPosition;
    public string _selection;
    
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