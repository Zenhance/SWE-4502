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






    }
}

