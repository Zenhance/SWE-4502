namespace TextEditor;

public class History
{
    private List<EditorMemento> _mementos;
    private Editor _editor;
     
    public History(Editor editor)
    {
        _editor = editor;
        _mementos = new List<EditorMemento>();
    }
     
    public void Backup()
    {
        _mementos.Add(_editor.CreateMemento());
    }
     
    public void Undo()
    {
        if (_mementos.Count == 0)
        {
            return;
        }
        var memento = _mementos.Last();
        _mementos.Remove(memento);
        _editor.Restore(memento);
    }
     
 
}