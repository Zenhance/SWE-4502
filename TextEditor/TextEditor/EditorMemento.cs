namespace TextEditor;

public class EditorMemento
{
    private string _content;
    private int _cursorPosition;
    private string _selection;
    public EditorMemento(string content, int cursorPosition, string selection)
    {
        _content = content;
        _cursorPosition = cursorPosition;
        _selection = selection;
    }

    public string GetContent()
    {
        return _content;
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
