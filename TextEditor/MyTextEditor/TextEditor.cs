using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyTextEditor
{
    using System;
    using System.Collections.Generic;

    namespace TextEditor
    {
        public class TextEditor
        {
            private string content;
            private int cursorPosition;
            private List<string> selections;

            public TextEditor()
            {
                content = string.Empty;
                cursorPosition = 0;
                selections = new List<string>();
            }

            public void SetContent(string newContent)
            {
                content = newContent;

                if (cursorPosition > content.Length)
                {
                    cursorPosition = content.Length;
                }
            }

            public void SetCursorPosition(int position)
            {
                if (position < 0)
                {
                    cursorPosition = 0;
                }
                else if (position > content.Length)
                {
                    cursorPosition = content.Length;
                }
                else
                {
                    cursorPosition = position;
                }
            }

            public void AddSelection(string selection)
            {
                selections.Add(selection);
            }

            public void ClearSelections()
            {
                selections.Clear();
            }

            public void DisplayState()
            {
                Console.WriteLine("=== Text Editor State ===");
                Console.WriteLine($"Content: {content}");
                Console.WriteLine($"Cursor Position: {cursorPosition}");
                Console.WriteLine("Selections:");

                if (selections.Count == 0)
                {
                    Console.WriteLine("empty");
                }
                else
                {
                    foreach (var selection in selections)
                    {
                        Console.WriteLine(selection);
                    }
                }
                Console.WriteLine("=======================");
            }

        }
    }
}
