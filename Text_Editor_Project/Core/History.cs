using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.Json;
using System.IO;

namespace Text_Editor_Project.Core
{
    public class History
    {
        public TextEditor textEditor;
        public List<EditorMemento> editorMementos;

        public History(TextEditor textEditor) {

            this.textEditor = textEditor;
        }

        public void Backup()
        {
            var editor= textEditor.CreateMemento();
            editorMementos.Add(editor);

            Console.WriteLine("Backup stored successfully.");



        }

        public void Undo()
        {

            if(editorMementos.Count > 0)
            {

                EditorMemento memento = editorMementos[editorMementos.Count-1];
                editorMementos.RemoveAt(editorMementos.Count-1);
                textEditor.RestoreFromMemento(memento);
                Console.WriteLine("Undo operation was successful.");
            }
            else
            {
                Console.WriteLine("nothing to restore.");
            }

        }

        public void SaveToFile(string filePath)
        {
            try
            {
                string json = JsonSerializer.Serialize(editorMementos, new JsonSerializerOptions { WriteIndented = true });
                File.WriteAllText(filePath, json);
                Console.WriteLine("History saved successfully to file.");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error saving history: {ex.Message}");
            }


        }

        public void LoadFromFile(string filePath)
        {
            if (!File.Exists(filePath))
            {
                Console.WriteLine("File not found.");
                return;
            }
            string json = File.ReadAllText(filePath);
            editorMementos = JsonSerializer.Deserialize<List<EditorMemento>>(json) ?? new List<EditorMemento>();
            Console.WriteLine("History loaded successfully from file.");

        }


    }
}
