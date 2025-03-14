using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace Lab12_textEditor
{
    public class History
    {
        private List<EditorMemento> _mementos;
        private Editor _editor;
        private History(Editor editor)
        {
            _editor = editor;
            _mementos =new List<EditorMemento>();
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
            _editor.RestoreFromMemento(memento);
        }
        public EditorMemento GetLastMemento()
        {
            return _mementos[_mementos.Count - 1];
        }
        public void SaveToFile(string path)
        {
            try
            {
                string json=JsonSerializer.Serialize(_mementos, new JsonSerializerOptions { WriteIndented=true})
                    File.WriteAllText(path, json);
                Console.WriteLine("History successfully saved to file.");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error saving history: {ex.Message}");
            }
        }
        public void LoadFromFile(string path)
        {
            try
            {
                string json = File.ReadAllText(path);
                _mementos = JsonSerializer.Deserialize<List<EditorMemento>>(json);
                Console.WriteLine("History successfully loaded from file.");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error loading history: {ex.Message}");
            }
        }

    }
}

