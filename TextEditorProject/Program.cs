using System;
using System.Collections.Generic;
using System.IO;
using System.Text.Json;

namespace TextEditorApp
{
    class Program
    {
        static void Main(string[] args)
        {
            TextEditor editor = new TextEditor();
            History history = new History(editor);

            editor.SetContent("Hello");
            history.Backup();

            editor.SetContent("Hello World");
            history.Backup();

            editor.DisplayState();
            history.Undo();
            editor.DisplayState();
        }
    }

}
