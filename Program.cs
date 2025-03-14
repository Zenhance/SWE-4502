using System;
using System.Collections.Generic;
using System.IO;
using System.Text.Json;

namespace TextEditorApp
{
    public class Program
    {
        static void main(string[] args)
        {
            TextEditor editor = new TextEditor();
            editor.SetContent("Hello World");
            editor.SetCursorPosition(5);
            editor.AddSelection("World");
            editor.DisplayState();
        }
    }

}
