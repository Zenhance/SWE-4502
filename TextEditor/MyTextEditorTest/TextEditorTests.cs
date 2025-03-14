using MyTextEditor;

namespace MyTextEditorTest
{
    public class TextEditorTests
    {
        [Fact]
        public void SetContent_ShouldUpdateContent()
        {
            var editor = new TextEditor();
            var history = new History(editor);

            editor.SetContent("abcd");
            history.Backup();

            var memento = editor.CreateMemento();
            Assert.Equal("abcd", memento.Content);
        }

        [Fact]
        public void SetCursorPosition_ValidPosition_ShouldUpdatePosition()
        {
            var editor = new TextEditor();
            editor.SetContent("Test Content");

            editor.SetCursorPosition(14);

            var memento = editor.CreateMemento();
            Assert.Equal(12, memento.CursorPosition);
        }

        [Fact]
        public void AddSelection_ShouldAddToSelections()
        {
            var editor = new TextEditor();

            editor.AddSelection("Selection 1");
            editor.AddSelection("Selection 2");

            var memento = editor.CreateMemento();
            Assert.Equal(2, memento.Selections.Count);
            Assert.Contains("Selection 1", memento.Selections);
            Assert.Contains("Selection 2", memento.Selections);
        }

        [Fact]
        public void ClearSelections_ShouldRemoveAllSelections()
        {
            var editor = new TextEditor();
            editor.AddSelection("Selection 1");
            editor.AddSelection("Selection 2");

            editor.ClearSelections();

            var memento = editor.CreateMemento();
            Assert.Empty(memento.Selections);
        }

        [Fact]
        public void SaveAndLoadState_ShouldPreserveEditorState()
        {
            var editor = new TextEditor();
            var history = new History(editor);

            editor.SetContent("abcdef");
            editor.SetCursorPosition(5);
            editor.AddSelection("Selection");
            history.Backup();

            string tempFile = "test_save_load.json";

            history.SaveToFile(tempFile);

            var newEditor = new TextEditor();
            var newHistory = new History(newEditor);
            newHistory.LoadFromFile(tempFile);

            var memento = newEditor.CreateMemento();
            Assert.Equal("abcdef", memento.Content);
            Assert.Equal(5, memento.CursorPosition);
            Assert.Single(memento.Selections);
            Assert.Equal("Selection", memento.Selections[0]);

            if (File.Exists(tempFile))
            {
                File.Delete(tempFile);
            }
        }

        [Fact]
        public void Undo_ShouldRestorePreviousState()
        {
            var editor = new TextEditor();
            var history = new History(editor);

            editor.SetContent("State 1");
            history.Backup();

            editor.SetContent("State 2");
            history.Backup();

            history.Undo(); 

            var memento = editor.CreateMemento();
            Assert.Equal("State 1", memento.Content);
        }
    }
}
