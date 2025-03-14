namespace TextEditor;

public class TextEditor
{
    private string _content;
    private int _cursorPosition;
    private string _selection;

    public TextEditor()
    {
        _content = string.Empty;
        _cursorPosition = 0;
        _selection = string.Empty;
    }

    public void SetContent(string content)
    {
        _content = content;
    }

    public void SetCursorPosition(int position)
    {
        if (position < 0 || position > _content.Length)
        {
            throw new ArgumentOutOfRangeException(nameof(position));
        }

        _cursorPosition = position;
    }

    public void AddSelection(string selection)
    {
        _selection = selection;
    }

    public void ClearSelection()
    {
        _selection = string.Empty;
    }

    public void DisplayState()
    {
        Console.WriteLine($"Content: {_content}");
        Console.WriteLine($"Cursor Position: {_cursorPosition}");
        Console.WriteLine($"Selection: {_selection}");
    }

    public EditorMemento CreateMemento()
    {
        return new EditorMemento(_content, _cursorPosition, _selection);
    }

    public void RestoreMemento(EditorMemento memento)
    {
        _content = memento.GetContent();
        _cursorPosition = memento.GetCursorPosition();
        _selection = memento.GetSelection();
    }
}
