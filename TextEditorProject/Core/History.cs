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
            var editor= textEditor.CreateMemento();
            editorMementos.Add(editor);

            Console.WriteLine("Backup stored successfully.");



        }

        public void Undo()
        {

            if(editorMementos.Count > 0)
            {

                EditorMemento memento = editorMementos[editorMementos.Count-1];
                editorMementos.RemoveAt(editorMementos.Count-1);
                textEditor.RestoreFromMemento(memento);
                Console.WriteLine("Undo operation was successful.");
            }
            else
            {
                Console.WriteLine("nothing to restore.");
            }

        }
    }
}
