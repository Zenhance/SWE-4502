using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TextEditorProject
{
    internal class Program
    {
        static void Main(string[] args)
        {
            TextEditor editor = new TextEditor();
            History history = new History(editor);

            editor.SetContent("Bye, world!");
            editor.SetCursorPosition(5);
            editor.AddSelection("World");

            history.Backup();

            editor.SetContent("New Content");
            history.Backup();

            
            history.Undo();
            editor.DisplayState();

            Console.ReadKey();
        }
    }
}
