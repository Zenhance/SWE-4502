namespace TextEditor;

public class Editor
{
    private string text;
    private int cursorPosition;
    private string selection;

    public Editor()
    {
        text = string.Empty;
        cursorPosition = 0;
        selection = string.Empty;
    }

    public void Insert(string text)
    {
        text = this.text.Insert(cursorPosition, text);
        cursorPosition += text.Length;
    }

    public void Delete(int length)
    {
        if (cursorPosition + length > text.Length)
        {
            length = text.Length - cursorPosition;
        }

        text = text.Remove(cursorPosition, length);
    }
    
    public void Select(int start, int length)
    {
        if (start + length > text.Length)
        {
            length = text.Length - start;
        }
        selection = text.Substring(start, length);
    }
    
    public void ClearSelection()
    {
        selection = string.Empty;
    }

    public void SetCursorPosition(int position)
    {
        if (position < 0)
        {
            position = 0;
        }

        if (position > text.Length)
        {
            position = text.Length;
        }
        cursorPosition = position;
    }

    

}