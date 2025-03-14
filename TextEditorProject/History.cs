using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TextEditorApp
{
    public class History
    {
        private List<EditorMemento> states;
        private TextEditor editor;

        public History(TextEditor editor)
        {
            this.editor = editor;
            states = new List<EditorMemento>();
        }

        public void Backup()
        {
            states.Add(editor.CreateMemento());
        }

        public void Undo()
        {
            if (states.Count > 0)
            {
                EditorMemento lastState = states[states.Count - 1];
                states.RemoveAt(states.Count - 1);
                editor.RestoreFromMemento(lastState);
            }
            else
            {
                Console.WriteLine("No history available.");
            }
        }
    }
}
