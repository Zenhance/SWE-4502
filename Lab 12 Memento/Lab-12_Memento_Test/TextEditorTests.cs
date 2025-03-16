using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Lab_12_Memento;

namespace Lab_12_Memento_Test
{
    [TestClass]
    public class TextEditorTests
    {
        [TestMethod]
        public void SetContent_ShouldUpdateContent()
        {
            // Arrange
            var editor = new TextEditor();
            string content = "Hello, world!";

            // Act
            editor.SetContent(content);

            // Assert
            Assert.AreEqual(content, editor.GetContent());
        }

        [TestMethod]
        public void SetCursorPosition_ValidPosition_ShouldUpdatePosition()
        {
            // Arrange
            var editor = new TextEditor();
            int position = 5;

            // Act
            editor.SetCursorPosition(position);

            // Assert
            Assert.AreEqual(position, editor.GetCursorPosition());
        }

        [TestMethod]
        public void AddSelection_ShouldAddToSelections()
        {
            // Arrange
            var editor = new TextEditor();
            string selection = "Hello";

            // Act
            editor.AddSelection(selection);

            // Assert
            CollectionAssert.Contains(editor.GetSelections(), selection);
        }

        [TestMethod]
        public void ClearSelections_ShouldRemoveAllSelections()
        {
            // Arrange
            var editor = new TextEditor();
            editor.AddSelection("Hello");
            editor.AddSelection("world");

            // Act
            editor.ClearSelections();

            // Assert
            Assert.AreEqual(0, editor.GetSelections().Count);
        }
    }
}
