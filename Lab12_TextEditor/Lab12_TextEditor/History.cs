using System.Runtime.Serialization.Formatters.Binary;
using Newtonsoft.Json;

namespace Lab12_TextEditor;

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


    public EditorMemento GetLastMemento()
    {
        return _mementos[_mementos.Count - 1];
    }


    public void SaveToJson(string path)
    {
        var json = JsonConvert.SerializeObject(_mementos[_mementos.Count - 1]);
        File.WriteAllText(path, json);
    }
    
    
    public void LoadFromJson(string path)
    {
        var json = File.ReadAllText(path);
        var memento = JsonConvert.DeserializeObject<EditorMemento>(json);
        _editor.Restore(memento);
    }
    

}