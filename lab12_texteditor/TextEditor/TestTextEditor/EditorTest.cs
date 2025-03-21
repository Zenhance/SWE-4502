using NUnit.Framework;
using TextEditor;

namespace TestTextEditor
{
    [TestFixture]
    public class EditorTest
    {
        [Test]
        public void TestInsert()
        {
            var editor = new Editor();
            editor.Insert("Hello");
            Assert.AreEqual("Hello", editor.GetText());
        }

        [Test]
        public void TestDelete()
        {
            var editor = new Editor();
            editor.Insert("Hello");
            editor.SetCursorPosition(2);
            editor.Delete(3);
            Assert.AreEqual("He", editor.GetText());
        }

        [Test]
        public void TestSelect()
        {
            var editor = new Editor();
            editor.Insert("Hello, World!");
            editor.Select(7, 5);
            Assert.AreEqual("World", editor.GetSelection());
        }

        [Test]
        public void TestClearSelection()
        {
            var editor = new Editor();
            editor.Insert("Hello, World!");
            editor.Select(7, 5);
            editor.ClearSelection();
            Assert.AreEqual(string.Empty, editor.GetSelection());
        }

        [Test]
        public void TestSetCursorPosition()
        {
            var editor = new Editor();
            editor.Insert("Hello");
            editor.SetCursorPosition(2);
            Assert.AreEqual(2, editor.GetCursorPosition());
        }

        [Test]
        public void TestCreateMemento()
        {
            var editor = new Editor();
            editor.Insert("Hello");
            editor.SetCursorPosition(2);
            editor.Select(0, 2);
            var memento = editor.CreateMemento();
            Assert.AreEqual("Hello", memento.GetText());
            Assert.AreEqual(2, memento.GetCursorPosition());
            Assert.AreEqual("He", memento.GetSelection());
        }
    }
} 