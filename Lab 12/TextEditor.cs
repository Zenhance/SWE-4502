public class Texteditor
{
    private string _content;
    private int _cursorposition;
    private List<string> _selections;

    public Texteditor()
    {
        _content = string.Empty;
        _cursorPosition = 0;
        _selections = new List<string>();
    }

    public void SetContent(string content)
    {
        _content = content;
    }
    public SetCursorPosition(int position)
    {
        if(position < 0 || position > _content.Length)
        {
            Console.WriteLine("Invalid cursor position.");
            return;
        }
        _cursorposition=position;
    }
    public AddSelection(string selection)
    {
        _selections.Add(selection);
    }
    public void ClearSelections()
    {
        _selections.Clear();

    }
    public void DisplayState()
    {
        Console.WriteLine($"Content: {_content}");
        Console.WriteLine($"Cursor Position: {_cursorPosition}");
        Console.WriteLine("Selections: " + string.Join(", ", _selections));
    }
     public void CreateMemento(){
        return new EditorMemento(_content, _cursorPosition, _selections);
    }
    public void RestoreFromMemento(EditorMemento memento){
        _content=memento.Content;
        _cursorPosition=memento.CursorPosition;
        _selections=new List<string>(memento.Selections);
    }
}