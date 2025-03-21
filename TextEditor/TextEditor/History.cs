using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;

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

    public void SaveToFile(string filePath)
    {
        var memento = _editor.CreateMemento();
        string serializedMemento;
        using (MemoryStream memoryStream = new MemoryStream())
        using (StreamReader reader = new StreamReader(memoryStream))
        {
            DataContractSerializer serializer = new DataContractSerializer(memento.GetType());
            serializer.WriteObject(memoryStream, memento);
            memoryStream.Position = 0;
            serializedMemento = reader.ReadToEnd();
        }

        File.WriteAllText(filePath, serializedMemento);
    }

    public void LoadFromFile(string filePath)
    {
        var data = File.ReadAllBytes(filePath);
        using (Stream stream = new MemoryStream())
        {
            stream.Write(data, 0, data.Length);
            stream.Position = 0;
            DataContractSerializer deserializer = new DataContractSerializer(typeof(EditorMemento));
            var memento = deserializer.ReadObject(stream)!;
            _editor.RestoreMemento((EditorMemento)memento);
        }
    }
}
