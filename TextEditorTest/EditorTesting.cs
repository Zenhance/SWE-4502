using TextEditorProject.Core;
using System;
using System.IO;
using Xunit;

namespace TextEditorTest
{
    public class EditorTesting
    {

        [Fact]
        public void SetContent_ShouldUpdateContent()
        {           
            var editor = new TextEditor();
            string newContent = "Hello, World!";
            editor.SetContent(newContent);

         
            using (var sw = new StringWriter())
            {
                Console.SetOut(sw);
                editor.DisplayState();
                string output = sw.ToString();
                Assert.Contains(newContent, output);
            }
        }
    }
}