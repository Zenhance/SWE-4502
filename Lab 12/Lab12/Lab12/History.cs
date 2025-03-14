using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab12
{
    public class History
    {
        private List<EditorMemento> _mementos = new List<EditorMemento>();
        private Editor _editor;

        public History(Editor editor)
        {
            _editor = editor;
        }
    }
}
