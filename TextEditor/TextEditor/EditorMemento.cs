namespace TextEditor;

public class EditorMemento
{
    public string Content { get; private set; }
    public int CursorPosition { get; private set; }
    public List<string> Selections { get; private set; }

    public EditorMemento(string content, int cursorPosition, List<string> selections)
    {
        Content = content;
        CursorPosition = cursorPosition;
        Selections = selections;
    }
}