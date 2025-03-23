using System.Text.Json;

namespace TextEditor;

public class History
{
    private List<EditorMemento> _mementos = new List<EditorMemento>();
    private TextEditor _textEditor;

    public History(TextEditor textEditor)
    {
        _textEditor = textEditor;
    }

    public void Backup()
    {
        Console.WriteLine("History: Saving editor state...");
        _mementos.Add(_textEditor.CreateMemento());
    }

    public void Undo()
    {
        if (_mementos.Count == 0)
        {
            Console.WriteLine("History: No more history to undo.");
            return;
        }

        var memento = _mementos[_mementos.Count - 1];
        _mementos.RemoveAt(_mementos.Count - 1);

        Console.WriteLine("History: Restoring to previous state...");
        _textEditor.RestoreFromMemento(memento);
    }

    public void SaveToFile(string filePath)
    {
        var currentState = _textEditor.CreateMemento();
        var jsonString = JsonSerializer.Serialize(currentState);
        File.WriteAllText(filePath, jsonString);
        Console.WriteLine($"Editor state saved to file: {filePath}");
    }

    public void LoadFromFile(string filePath)
    {
        if (!File.Exists(filePath))
        {
            Console.WriteLine($"File not found: {filePath}");
            return;
        }

        try
        {
            var jsonString = File.ReadAllText(filePath);
            var memento = JsonSerializer.Deserialize<EditorMemento>(jsonString);
            _textEditor.RestoreFromMemento(memento);
            Console.WriteLine($"Editor state loaded from file: {filePath}");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error loading file: {ex.Message}");
        }
    }
}