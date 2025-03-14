// See https://aka.ms/new-console-template for more information

using TextEditor;

TextEditor.TextEditor textEditor = new ();

textEditor.SetContent("Hello, World!");
textEditor.SetCursorPosition(5);
textEditor.AddSelection("World");
textEditor.DisplayState();

EditorMemento memento = textEditor.CreateMemento();

textEditor.ClearSelection();
textEditor.SetContent("Hello, Mars!");
textEditor.SetCursorPosition(0);
textEditor.DisplayState();

textEditor.RestoreMemento(memento);
textEditor.DisplayState();