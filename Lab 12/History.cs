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
    public void SaveToFile(string filePath)
    {
        try
        {
            string json = JsonSerializer.Serialize(_mementos);
            File.WriteAllText(filePath, json);
            Console.WriteLine(" History saved to file.");

        }
        catch
         {
            Console.WriteLine("Failed to save history to file.");
         }
    }
    public void LoadFromFile(string filePath)
    {
         try
        {
            string json = File.ReadAllText(filePath) ;
            _mementos.Clear();
            _mementos.AddRange(JsonSerializer.Deserialize<List<EditorMemento>>(json));
            Console.WriteLine(" History loaded from file.");

        }
        catch
         {
            Console.WriteLine("Error loading file");
         }

    }
}