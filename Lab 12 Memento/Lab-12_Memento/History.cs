using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json;
using System.IO;
using System.Text;
using System.Threading.Tasks;

namespace Lab_12_Memento
{
    public class History
    {
        private TextEditor editor;
        private List<EditorMemento> history;
        private int currentIndex;

        public History(TextEditor editor) 
        {
            this.editor = editor;
            history = new List<EditorMemento>();
            currentIndex = -1;
        }

        public void Backup()
        {
            EditorMemento snapshot = editor.CreateMemento();
            
            if (currentIndex < history.Count - 1)
            {
                history.RemoveRange(currentIndex + 1, history.Count - currentIndex - 1);
            }
            history.Add(snapshot);
            currentIndex++;
            Console.WriteLine("State saved.");

        }

        public void Undo()
        {
            if (currentIndex <= 0)
            {
                Console.WriteLine("Nothing to undo");
            }
            currentIndex--;
            editor.RestoreFromMemento(history[currentIndex]);
            Console.WriteLine("Succesfully Undone.");
        }

        public void SaveToFile(string filePath)
        {
            try
            {
                using (StreamWriter writer = new StreamWriter(filePath))
                {
                    foreach (var memento in history)
                    {
                        string selectionData = string.Join(";", memento.Selections);
                        writer.WriteLine($"{memento.Content}|{memento.CursorPosition}|{selectionData}");
                    }
                }
                Console.WriteLine($"History saved to {filePath}");
            }

            catch (Exception ex)
            {
                Console.WriteLine($"Error saving file: {ex.Message}");
            }
        }

        public void LoadFromFile(string filePath)
        {
            try
            {
                if (!File.Exists(filePath))
                {
                    Console.WriteLine("File does not exist.");
                    return;
                }

                history.Clear();

                using (StreamReader reader = new StreamReader(filePath))
                {
                    string line;
                    while ((line = reader.ReadLine()) != null)
                    {
                        string[] parts = line.Split('|');
                        if (parts.Length == 3)
                        {
                            string content = parts[0];
                            int cursorPosition = int.Parse(parts[1]);
                            List<string> selections = new List<string>(parts[2].Split(';'));

                            history.Add(new EditorMemento(content, cursorPosition, selections));
                        }
                    }
                }

                currentIndex = history.Count - 1;
                if (currentIndex >= 0)
                {
                    editor.RestoreFromMemento(history[currentIndex]);
                }

                Console.WriteLine($"History loaded from {filePath}");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error loading file: {ex.Message}");
            }
        }


        public void DisplayHistory()
        {
            Console.WriteLine($"History states: {history.Count}, Current index: {currentIndex}");
        }
    }
}
