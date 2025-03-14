using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TextEditorApp
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
            cursorPosition = content.Length;
        }

        public void SetCursorPosition(int position)
        {
            if (position >= 0 && position <= content.Length)
                cursorPosition = position;
            else
                Console.WriteLine("Invalid cursor position.");
        }

        public void AddSelection(string selection)
        {
            selections.Add(selection);
        }

        public void ClearSelections()
        {
            selections.Clear();
        }

        public void DisplayState()
        {
            Console.WriteLine($"Content: {content}");
            Console.WriteLine($"Cursor Position: {cursorPosition}");
            Console.WriteLine($"Selections: {string.Join(", ", selections)}");
        }
    }
}
