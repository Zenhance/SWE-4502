using System;
using System.Collections.Generic;
using System.IO;
using System.Text.Json;

namespace TextEditorApp
{
    public class History
    {
        private List<EditorMemento> states;
        private TextEditor editor;

        public History(TextEditor editor)
        {
            this.editor = editor;
            states = new List<EditorMemento>();
        }

        public void Backup()
        {
            states.Add(editor.CreateMemento());
        }

        public void SaveToFile(string filePath)
        {
            try
            {
                string json = JsonSerializer.Serialize(states);
                File.WriteAllText(filePath, json);
                Console.WriteLine("History saved successfully.");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error saving history: {ex.Message}");
            }
        }

        public void LoadFromFile(string filePath)
        {
            try
            {
                if (File.Exists(filePath))
                {
                    string json = File.ReadAllText(filePath);
                    states = JsonSerializer.Deserialize<List<EditorMemento>>(json) ?? new List<EditorMemento>();
                    Console.WriteLine("History loaded successfully.");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error loading history: {ex.Message}");
            }
        }
    }
}
