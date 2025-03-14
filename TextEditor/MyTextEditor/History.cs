using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace MyTextEditor
{
    public class History
    {
        private TextEditor editor;
        private List<Memento> history;

        public History(TextEditor editor)
        {
            this.editor = editor;
            history = new List<Memento>();
        }

        public void Backup()
        {
            history.Add(editor.CreateMemento());
        }

        private class SerializableState
        {
            public string Content { get; set; }
            public int CursorPosition { get; set; }
            public List<string> Selections { get; set; }
        }

        public void SaveToFile(string filePath)
        {
            try
            {
                var serializableStates = new List<SerializableState>();

                foreach (var memento in history)
                {
                    serializableStates.Add(new SerializableState
                    {
                        Content = memento.Content,
                        CursorPosition = memento.CursorPosition,
                        Selections = memento.Selections
                    });
                }

                string jsonString = JsonSerializer.Serialize(serializableStates, new JsonSerializerOptions { WriteIndented = true });
                File.WriteAllText(filePath, jsonString);
                Console.WriteLine($"History successfully saved to {filePath}");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error saving to file: {ex.Message}");
            }
        }

        public void LoadFromFile(string filePath)
        {
            try
            {
                if (!File.Exists(filePath))
                {
                    Console.WriteLine($"File not found: {filePath}");
                    return;
                }

                string jsonString = File.ReadAllText(filePath);
                var serializableStates = JsonSerializer.Deserialize<List<SerializableState>>(jsonString);

                history.Clear();

                foreach (var state in serializableStates)
                {
                    history.Add(new Memento(
                        state.Content,
                        state.CursorPosition,
                        state.Selections
                    ));
                }

                Console.WriteLine($"History: Successfully loaded {history.Count} states from {filePath}");

                if (history.Count > 0)
                {
                    editor.RestoreFromMemento(history[history.Count - 1]);
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error loading from file: {ex.Message}");
            }
        }
    }
}

