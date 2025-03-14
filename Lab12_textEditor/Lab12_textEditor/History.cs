using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab12_textEditor
{
    public class History
    {
        private List<EditorMemento> _mementos;
        private Editor _editor;
        private History(Editor editor)
        {
            _editor = editor;
            _mementos =new List<EditorMemento>();
        }
        public void Backup()
        {
            _mementos.Add(_editor.CreateMemento());
        }
        public void Undo()
        {
            if (_mementos.Count == 0)
            {
                return;
            }
            var memento = _mementos.Last();
            _mementos.Remove(memento);
            _editor.RestoreFromMemento(memento);
        }
       

    }
}

