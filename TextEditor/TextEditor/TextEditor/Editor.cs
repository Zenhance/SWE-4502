using System.Net.Sockets;

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

    public void insert(string text)
    {
        this.text = this.text.Insert(cursorPosition, text);
        cursorPosition += text.Length;
    }

    public void delete(int length)
    {
        if (cursorPosition + length < this.text.Length)
        {
            length = this.text.Length - cursorPosition;
        }
        this.text = this.text.Remove(cursorPosition, length);
    }

    public void Select(int start, int length)
    {
        if (start + length > this.text.Length)
        {
            length = this.text.Length - start;
        }
        
        selection = this.text.Substring(start, length);
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

        if (position > this.text.Length)
        {
            position = this.text.Length;
        }
        
        cursorPosition = position;
    }
}