using System;
using System.Collections.Generic;
using System.Text.Json;
using System.IO;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace TextEditorProject
{
    public class History //caretaker class
    {
        public List<EditorMemento> States = new List<EditorMemento>();
        public TextEditor editor;

        public History(TextEditor editor)
        {
            this.editor = editor;
        }
        public void Backup()
        {
            States.Add(editor.CreateMemento());
        }
        public void Undo()
        {
            if(States.Count > 0)
            {
                EditorMemento memento = States[States.Count - 1];
                States.RemoveAt(States.Count - 1);
                editor.RestoreFromMemento(memento);
            }
            else
            {
                Console.WriteLine("No saved states found.");
            }
            
        }

        public void SaveToFile(string filePath)
        {
            try
            {
                string json = JsonSerializer.Serialize(States, new JsonSerializerOptions { WriteIndented = true });
                //string json = JsonSerializer.Serialize(States);
                File.WriteAllText(filePath, json);
            }
            catch
            {
                Console.WriteLine("Error saving files.");
            }
        }
        public void LoadFromFile(string filePath)
        {
            try
            {
                if (!File.Exists(filePath))
                {
                    Console.WriteLine("No such file path exists.");
                    return;
                }
                else
                {
                    string json = File.ReadAllText(filePath);
                    States = JsonSerializer.Deserialize<List<EditorMemento>>(json);
                    Console.WriteLine($"States loaded from file: {filePath}");
                }
            }
            catch
            {
                Console.WriteLine("Error loading file.");
            }

        }
    }
}
