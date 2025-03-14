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

    }
}
