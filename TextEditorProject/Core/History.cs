using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TextEditorProject.Core
{
    public class History
    {
        public TextEditor textEditor;
        public List<EditorMemento> editorMementos;

        public History(TextEditor textEditor) {

            this.textEditor = textEditor;
        }

        public void Backup()
        {

        }

        public void Undo()
        {

        }
    }
}
