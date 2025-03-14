using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TextEditorProject
{
    public class TextEditor
    {
        private string Content;
        private int CursorPosition;
        private List<string> Selections;

        public TextEditor()
        {
            Content = string.Empty;
            CursorPosition = 0;
            Selections = new List<string>();
        }

        public void SetContent(string content)
        {
            if (content == null)
            {
                Content = string.Empty;
            }
            else
            {
                this.Content = content;
            }
        }
        public void SetCursorPosition(int position)
        {
            if (position < 0 || position > Content.Length)
            {
                Console.WriteLine("Cursor is out of range");
            }
            else
            {
                CursorPosition = position;
            }
        }
        public void AddSelection(string selection)
        {
            Selections.Add(selection);
        }

        public void ClearSelections()
        {
            Selections.Clear();
        }
        public void DisplayState()
        {
            Console.WriteLine($"{Content}");
            Console.WriteLine($"{CursorPosition}");
            Console.WriteLine($"{Selections}");
        }

        public EditorMemento CreateMemento()
        {
            return new EditorMemento(Content, CursorPosition,Selections);
        }

        public void RestoreFromMemento(EditorMemento memento)
        {
            Content = memento.Content;
            CursorPosition = memento.CursorPosition;
            Selections = new List<string>(memento.Selections);
        }
    }
}
