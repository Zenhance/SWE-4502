using TextEditorApp;

class Program
{
    static void Main(string[] args)
    {
        TextEditor editor = new TextEditor();
        History history = new History(editor);

        editor.SetContent("Sample Text");
        history.Backup();

        history.SaveToFile("history.json");
        history.LoadFromFile("history.json");
    }
}
