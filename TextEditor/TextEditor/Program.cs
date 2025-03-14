// See https://aka.ms/new-console-template for more information

using TextEditor;

TextEditor.TextEditor textEditor = new ();
History history = new(textEditor);

textEditor.SetContent("Hello, World!");
textEditor.SetCursorPosition(5);
textEditor.AddSelection("World");
textEditor.DisplayState();

history.Backup();

textEditor.ClearSelection();
textEditor.SetContent("Hello, Mars!");
textEditor.SetCursorPosition(0);
textEditor.DisplayState();

history.Undo();

textEditor.DisplayState();