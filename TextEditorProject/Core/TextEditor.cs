using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TextEditorProject.Core
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

        public void SetContent(string content) { 
            
            this.content = content ?? string.Empty;
            cursorPosition = 0;
            selections = new List<string>();
        
        }

        public void SetCursorPosition(int position)
        {
            if(position<0 ||  position > this.content.Length)
            {
                Console.WriteLine("Invalid cursor position.");

                return;
            }

            cursorPosition = position;
        }

        public void AddSelection(string selection)
        {
            if (!string.IsNullOrEmpty(selection))
            {
                selections.Add(selection);
            }
        }

        public void ClearSelections()
        {
            selections.Clear();
        }

        public void DisplayState()
        {
            Console.WriteLine("Editors issue:");
            Console.WriteLine($"Content: {content}");
            Console.WriteLine($"Position of cursor: {cursorPosition}");

            Console.WriteLine("Selections: ");

            if(selections.Count == 0 ) {
                Console.WriteLine(" None.");
            }
            else
            {
                foreach(var sel in selections)
                {
                    Console.WriteLine($" {sel}");
                }
            }
        }

        public void CreateMemento()
        {
            //
        }

        public void RestoreFromMemento(EditorMemento memento)
        {
           //

        }

    }
}
