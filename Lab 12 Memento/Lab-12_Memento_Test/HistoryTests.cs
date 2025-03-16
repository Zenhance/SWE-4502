using System;
using Lab_12_Memento;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.IO;

namespace Lab_12_Memento_Test
{
    [TestClass]
    public class HistoryTests
    {
        [TestMethod]
        public void Backup_ShouldSaveState()
        {
            // Arrange
            var editor = new TextEditor();
            var history = new History(editor);
            editor.SetContent("First Content");
            history.Backup();

            // Act
            editor.SetContent("Second Content");

            // Assert
            history.Undo(); // Undo to first state
            Assert.AreEqual("First Content", editor.GetContent());
        }

        [TestMethod]
        public void Undo_ShouldRestorePreviousState()
        {
            // Arrange
            var editor = new TextEditor();
            var history = new History(editor);
            editor.SetContent("First Content");
            history.Backup();

            editor.SetContent("Second Content");

            // Act: Undo
            history.Undo();

            // Assert
            Assert.AreEqual("First Content", editor.GetContent());
        }

        [TestMethod]
        public void SaveAndLoadState_ShouldPreserveEditorState()
        {
            // Arrange
            var editor = new TextEditor();
            var history = new History(editor);
            editor.SetContent("Test Content");
            history.Backup();

            string filePath = "testHistory.json";
            history.SaveToFile(filePath);

            editor.SetContent("New Content");
            history.LoadFromFile(filePath);

            // Act
            Assert.AreEqual("Test Content", editor.GetContent());
        }

        [TestMethod]
        public void SaveToFile_ShouldSaveStateToFile()
        {
            // Arrange
            var editor = new TextEditor();
            var history = new History(editor);
            editor.SetContent("Test Save Content");
            history.Backup();
            string filePath = "testSave.json";

            // Act
            history.SaveToFile(filePath);

            // Assert
            Assert.IsTrue(File.Exists(filePath));

            // Cleanup
            File.Delete(filePath);
        }

        [TestMethod]
        public void LoadFromFile_ShouldLoadStateFromFile()
        {
            // Arrange
            var editor = new TextEditor();
            var history = new History(editor);
            editor.SetContent("Test Content Before Load");
            history.Backup();
            string filePath = "testLoad.json";

            history.SaveToFile(filePath);

            editor.SetContent("New Content");
            history.LoadFromFile(filePath);

            // Act
            Assert.AreEqual("Test Content Before Load", editor.GetContent());

            // Cleanup
            File.Delete(filePath);
        }
    }
}
