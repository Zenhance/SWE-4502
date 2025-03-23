namespace TextEditor;

public class TextEditor
{
    private string _content;
    private int _cursorPosition;
    private List<string> _selections;

    public TextEditor()
    {
        _content = "";
        _cursorPosition = 0;
        _selections = new List<string>();
    }

    public void SetContent(string content)
    {
        _content = content;
        Console.WriteLine($"Content set to: {_content}");
    }

    public void SetCursorPosition(int position)
    {
        if (position >= 0 && position <= _content.Length)
        {
            _cursorPosition = position;
            Console.WriteLine($"Cursor moved to position: {_cursorPosition}");
        }
        else
        {
            Console.WriteLine("Invalid cursor position.");
        }
    }

    public void AddSelection(string selection)
    {
        _selections.Add(selection);
        Console.WriteLine($"Added selection: {selection}");
    }

    public void ClearSelections()
    {
        _selections.Clear();
        Console.WriteLine("All selections cleared.");
    }

    public void DisplayState()
    {
        Console.WriteLine("\n--- Current Editor State ---");
        Console.WriteLine($"Content: {_content}");
        Console.WriteLine($"Cursor Position: {_cursorPosition}");
        Console.WriteLine("Selections:");
        foreach (var selection in _selections)
        {
            Console.WriteLine($"  - {selection}");
        }
        Console.WriteLine("---------------------------\n");
    }

    public EditorMemento CreateMemento()
    {
        return new EditorMemento(_content, _cursorPosition, new List<string>(_selections));
    }

    public void RestoreFromMemento(EditorMemento memento)
    {
        _content = memento.Content;
        _cursorPosition = memento.CursorPosition;
        _selections = new List<string>(memento.Selections);
        Console.WriteLine(_content);
        Console.WriteLine("Editor state restored from memento.");
    }
}