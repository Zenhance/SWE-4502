namespace TextEditor;

public class History
{
    private TextEditor _editor;
    private List<EditorMemento> _history = new();
    
    public History(TextEditor textEditor)
    {
        _editor = textEditor;
    }

    public void Backup()
    {
        _history.Add(_editor.CreateMemento());
    }

    public void Undo()
    {
        if (_history.Count == 0)
        {
            return;
        }
        EditorMemento memento = _history.Last();
        _history.Remove(memento);
        _editor.RestoreMemento(memento);
    }
}
