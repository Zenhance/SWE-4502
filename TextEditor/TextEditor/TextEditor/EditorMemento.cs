using System.Runtime.Serialization;

namespace TextEditor;

public class EditorMemento
{
    private readonly string text;
    private readonly int cursorPosition;
    private readonly string selection;

    public EditorMemento(string text, int cursorPosition, string selection)
    {
        this.text = text;
        this.cursorPosition = cursorPosition;
        this.selection = selection;
    }

    public string GetText()
    {
        return text;
    }

    public int GetCursorPosition()
    {
        return cursorPosition;
    }

    public string GetSelection()
    {
        return selection;
    }
    
}