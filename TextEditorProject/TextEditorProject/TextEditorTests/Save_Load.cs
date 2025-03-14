using TextEditorProject;

namespace TextEditorTests
{
    public class Save_Load
    {
        private readonly string FilePath = "DumpStates.json";
        [Fact]
        public void SaveFile()
        {
            TextEditor editor = new TextEditor();
            History history = new History(editor);
            editor.SetContent("NAMISA");
            editor.SetCursorPosition(4);
            editor.AddSelection("NAMI");

            history.Backup();

            history.SaveToFile(FilePath);

            Assert.True(File.Exists(FilePath));

            if (File.Exists(FilePath))
            {
                File.Delete(FilePath);
            }

        }
        [Fact]
        public void LoadFile()
        {
            TextEditor editor = new TextEditor();
            History history = new History(editor);
            editor.SetContent("NAJAH");
            editor.SetCursorPosition(3);
            history.Backup();
            history.SaveToFile(FilePath);

            History newHistory = new History(editor);
            newHistory.LoadFromFile(FilePath);

            Assert.Equal(1, newHistory.States.Count);

            if (File.Exists(FilePath))
                File.Delete(FilePath);
        }
    }
}