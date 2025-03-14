using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace MyTextEditor
{
    public class History
    {
        private TextEditor editor;
        private List<EditorMemento> history;

        public History(TextEditor editor)
        {
            this.editor = editor;
            history = new List<EditorMemento>();
        }

        public void Backup()
        {
            history.Add(editor.CreateMemento());
        }
    }
}
