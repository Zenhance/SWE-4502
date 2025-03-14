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
    }
}