// See https://aka.ms/new-console-template for more information

TextEditor.TextEditor textEditor = new ();

textEditor.SetContent("Hello, World!");
textEditor.SetCursorPosition(5);
textEditor.AddSelection("World");
textEditor.DisplayState();
