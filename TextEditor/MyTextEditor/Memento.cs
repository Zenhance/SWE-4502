using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyTextEditor
{
    public class Memento
    {
        public string Content { get; }
        public int CursorPosition { get; }
        public List<string> Selections { get; }

        public Memento(string content, int cursorPosition, List<string> selections)
        {
            Content = content;
            CursorPosition = cursorPosition;
            Selections = selections;
        }
    }
}
