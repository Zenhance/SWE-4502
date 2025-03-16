using System;
using System.Collections.Generic;
using System.IO;
using System.Text.Json;

namespace Lab_12_Memento
{
    public class History
    {
        private List<EditorMemento> states;
        private TextEditor editor;

        // Constructor to initialize the History with an instance of TextEditor
        public History(TextEditor editor)
        {
            this.editor = editor;
            states = new List<EditorMemento>();
        }

        // Method to save the current state of the editor
        public void Backup()
        {
            states.Add(editor.CreateMemento()); // Create a snapshot of the editor state and save it
        }

        // Method to undo to the last state
        public void Undo()
        {
            if (states.Count > 0)
            {
                EditorMemento lastState = states[states.Count - 1]; // Access the most recent state
                states.RemoveAt(states.Count - 1); // Remove the last state from the history
                editor.RestoreFromMemento(lastState); // Restore the editor to that state
                Console.WriteLine("Undo successful.");
            }
            else
            {
                Console.WriteLine("No previous states to undo.");
            }
        }

        // Method to save the history of states to a file
        public void SaveToFile(string filePath)
        {
            try
            {
                string jsonString = JsonSerializer.Serialize(states, new JsonSerializerOptions { WriteIndented = true });
                File.WriteAllText(filePath, jsonString); // Write the serialized JSON string to a file
                Console.WriteLine($"History saved successfully to {filePath}.");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error saving history: {ex.Message}");
            }
        }

        // Method to load the history of states from a file
        public void LoadFromFile(string filePath)
        {
            try
            {
                if (File.Exists(filePath))
                {
                    string jsonString = File.ReadAllText(filePath); // Read the file contents
                    states = JsonSerializer.Deserialize<List<EditorMemento>>(jsonString) ?? new List<EditorMemento>(); // Deserialize the JSON into a list of mementos
                    Console.WriteLine($"History loaded successfully from {filePath}.");
                }
                else
                {
                    Console.WriteLine("No saved history found.");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error loading history: {ex.Message}");
            }
        }
    }
}
