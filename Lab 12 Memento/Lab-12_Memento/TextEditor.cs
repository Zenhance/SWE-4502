using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_12_Memento
{
    public class TextEditor
    {
        private string content;
        private int cursorPosition;
        private List<string> selections;

        public TextEditor()
        {
            content = "";
            cursorPosition = 0;
            selections = new List<string>();
        }

        public void SetContent(string newContent)
        {
            content = newContent;
        }

        public string GetContent()
        {
            return content;
        }

        public void SetCursorPosition(int position)
        {
            if (position >= 0 && position <= content.Length)
                cursorPosition = position;
        }

        public int GetCursorPosition()
        {
            return cursorPosition;
        }

        public void AddSelection(string selection)
        {
            selections.Add(selection);
        }

        public List<string> GetSelections()
        {
            return new List<string>(selections); 
        }

        public void ClearSelections()
        {
            selections.Clear();
        }

        public EditorMemento CreateMemento()
        {
            return new EditorMemento(content, cursorPosition, new List<string>(selections)); 
        }

        public void RestoreFromMemento(EditorMemento memento)
        {
            content = memento.Content;
            cursorPosition = memento.CursorPosition;
            selections = new List<string>(memento.Selections); 
        }

        public void DisplayState()
        {
            Console.WriteLine("Content: " + content);
            Console.WriteLine("Cursor Position: " + cursorPosition);
            Console.WriteLine("Selections: " + string.Join(", ", selections));
        }
    }
}
