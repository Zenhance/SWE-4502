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
            content = string.Empty;
            cursorPosition = 0;
            selections = new List<string>();
        }

        public void SetContent(string newContent)
        {
            content = newContent;
            cursorPosition = content.Length;
        }

        public void SetCursorPosition(int position)
        {
            cursorPosition = position;
        }

        public void AddSelection(string selection)
        {
            selections.Add(selection);
        }


        public void ClearSelection(string selection)
        {
            selections.Clear();
        }

        public EditorMemento CreateMemento()
        {
            return new EditorMemento(content, cursorPosition, selections);
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
            Console.WriteLine("");

        }
    }
}
