using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Lab12_textEditor;
using Xunit;
namespace Lab12_textEditor.test
{
    
    public class BasicEditorTest
    {


        [Fact]
        public void CreateEditor()
        {
            Editor editor = new Editor();
            Assert.NotNull(editor);
        }

        [Fact]
        public void EditorInitializationTest()
        {
            Editor editor = new Editor();
            Assert.Equal("", editor.GetText());
            Assert.Equal(0, editor.GetCursorPosition());
            Assert.Equal("", editor.GetSelection());
        }
        [Fact]
        public void InsertTextToEditorTest()
        {
            string testString = "I Am Emon";
            int actualCursorPosition = testString.Length;
            Editor editor = new Editor();
            editor.Insert(testString);
            Assert.Equal(testString, editor.GetText());
            Assert.Equal(actualCursorPosition, editor.GetCursorPosition());
        }
        [Fact]
        public void DeleteTextFromEditorTest()
        {
            string testString = "I Am Emon";
            Editor editor = new Editor();
            editor.Insert(testString);
            editor.SetCursorPosition(0);
            editor.Delete(1);
            Assert.Equal(" Am Emon", editor.GetText());
        }

        [Fact]
        public void SelectTextInEditorTest()
        {
            string testString = "I am emon";
            int start = 5;
            int length = 4;
            string expectedSelection = "emon";

            Editor editor = new Editor();
            editor.Insert(testString);
            editor.Select(start, length);

            Assert.Equal(expectedSelection, editor.GetSelection());
        }






    }
}

