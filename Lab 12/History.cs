public class History
{

    private readonly List<EditorMemento> _mementos;
    private readonly TextEditor _texteditor;
    public History(TextEditor textEditor)
    {
        _textEditor = textEditor;
    }
    public void Backup()
    {
        _mementos.Add(_textEditor.CreateMemento());
    }
    public void Undo()
    {
        if (_mementos.Count == 0)
        {
            Console.WriteLine("No mementos to undo.");
            return;
        }
        var lastmemento = _mementos.Last();
        _mementos.Remove(lastmemento);
        _textEditor.RestoreFromMemento(memento);
    }
    
}