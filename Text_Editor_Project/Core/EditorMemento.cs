using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Text_Editor_Project.Core
{
    public class EditorMemento
    {
        public string Content { get; set; }
        public int CursorPosition { get; set; }

        public List<string> Selections { get; set; }

        public EditorMemento(string content, int cursorPos, List<string> selections) {

            Content = content;
            CursorPosition = cursorPos;
            Selections = new List<string>(selections);
        
        
        }
        public EditorMemento()
        {
            Content = string.Empty;
            CursorPosition = 0;
            Selections = new List<string>();
        }

     





    }
}
