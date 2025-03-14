using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TextEditorProject
{
    public class EditorMemento
    {
        public string Content { get; set; }
        public int CursorPosition { get; set; }
        public List<string> Selections { get; set; }

        public EditorMemento(string content, int cursorposition, List<string> selections)
        {
            Content = content;
            CursorPosition = cursorposition;
            Selections = selections;
        }
    }
}
