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
    }
}