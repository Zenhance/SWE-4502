using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab12_textEditor
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
        public void Insert(string text)
        {
            _text = _text.Insert(_cursorPosition, text);
            _cursorPosition += text.Length;
        }

        public void Delete(int length)
        {
            if (_cursorPosition+length >_text.Length)
            {
                length = _text.Length - _cursorPosition;
            }
            _text = _text.Remove(_cursorPosition, length);
        }
        public void clearSelection()
        {
            _selection = string.Empty;
        }
        public void SetCursorPosition(int position)
        {

            if (position < 0)
            {
                position=0;
            }
            if (position>_text.Length)
            {
                position = _text.Length;
            }
            _cursorPosition = position;

        }
        public string GetText()
        {
            return _text;
        }

        public int GetCursorPosition()
        {
            return _cursorPosition;
        }

        public string GetSelection()
        {
            return _selection;
        }
        //Add to TextEditor:
        //- CreateMemento() method
        //- RestoreFromMemento(EditorMemento memento) method

        public EditorMemento CreateMemento()
        {
            return new EditorMemento(_text, _cursorPosition, _selection);
        }
        public void RestoreFromMemento(EditorMemento memento)
        {
            _text = memento.GetText();
            _cursorPosition = memento.GetCursorPosition();
            _selection = memento.GetSelection();
        }

    }
}
