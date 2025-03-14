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

        public void Backup()
        {
            _mementos.Add(_editor.CreateMemento());
            Console.WriteLine("State Saved ");
        }

        public void Undo()
        {
            if (_mementos.Count == 0)
            {
                Console.WriteLine("No states to undo!");
                return;
            }

            var lastMemento = _mementos[_mementos.Count - 1];
            _mementos.RemoveAt(_mementos.Count - 1);
            _editor.RestoreMemento(lastMemento);
            Console.WriteLine("Undo completed.");
        }
    }
}
