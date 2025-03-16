using Lab_12_Memento;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_12_Memento_Test
{
    [TestClass]
    public class MementoTests
    {
        [TestMethod]
        public void CreateMemento_ShouldCreateValidMemento()
        {
            // Arrange
            var editor = new TextEditor();
            editor.SetContent("Sample content");
            editor.SetCursorPosition(10);
            editor.AddSelection("Sample");

            // Act
            var memento = editor.CreateMemento();

            // Assert
            Assert.AreEqual("Sample content", memento.Content);
            Assert.AreEqual(10, memento.CursorPosition);
            CollectionAssert.Contains(memento.Selections, "Sample");
        }

        [TestMethod]
        public void RestoreFromMemento_ShouldRestoreValidState()
        {
            // Arrange
            var editor = new TextEditor();
            editor.SetContent("Old Content");
            editor.SetCursorPosition(5);
            editor.AddSelection("Selection");

            var memento = editor.CreateMemento();

            // Act
            editor.SetContent("New Content");
            editor.SetCursorPosition(20);
            editor.ClearSelections();
            editor.RestoreFromMemento(memento);

            // Assert
            Assert.AreEqual("Old Content", editor.GetContent());
            Assert.AreEqual(5, editor.GetCursorPosition());
            CollectionAssert.Contains(editor.GetSelections(), "Selection");
        }
    }
}
