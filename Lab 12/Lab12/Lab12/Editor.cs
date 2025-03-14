using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab12
{
    public class Editor
    {
        private string _text;
        private int _cursorPosition;
        private string _selection;

        public Editor()
        {
            _text = string.Empty;
            _cursorPosition = 0;
            _selection = string.Empty;
        }

        public void SetText(string text)
        {
            _text = text;
            _cursorPosition = text.Length;
            _selection = string.Empty;
        }

        public void SetCursorPosition(int position)
        {
            _cursorPosition = Math.Max(0, Math.Min(_text.Length, position));
        }

        public void Insert(string text)
        {
            _text = _text.Insert(_cursorPosition, text);
            _cursorPosition += text.Length;
        }

        public void Delete(int length)
        {
            if(_cursorPosition + length>_text.Length)
            {
                length = _text.Length - _cursorPosition;
            }
            else
            {
                _text = _text.Remove(_cursorPosition, length);
            }
        }

        public void Select(int start, int length)
        {
            if (start+length > _text.Length)
            {
                length = _text.Length - start;
            }
            _selection = _text.Substring(start, length);
        }

        public void addSelection(string selection)
        {
            if (!string.IsNullOrEmpty(_selection))
            {
                _selection += selection;
            }
            else
            {
                _selection = selection;
            }
        }

        public void DeleteSelection()
        {
            if (!string.IsNullOrEmpty(_selection))
            {
                _text = _text.Replace(_selection, string.Empty);
                _selection = string.Empty;
            }
        }

        public void Display()
        {
            Console.WriteLine("Text: " + _text);
            Console.WriteLine("Cursor Position: " + _cursorPosition);
            Console.WriteLine("Selection: " + _selection);
        }
    }

}
