using System.Runtime.Serialization;

namespace TextEditor;

[Serializable]
public class EditorMemento: ISerializable
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

    public void GetObjectData(SerializationInfo info, StreamingContext context)
    {
        info.AddValue("Content", _content);
        info.AddValue("CursorPosition", _cursorPosition);
        info.AddValue("Selection", _selection);
    }

    public string GetSelection()
    {
        return _selection;
    }
}
