using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Lab12_textEditor
{
    public class EditorMemento : ISerializable
    {
        public string _text;
        public int _cursorPosition;
        public string _selection;
        public EditorMemento(string text, int cursorPosition, string selection)
        {
            _text = text;
            _cursorPosition = cursorPosition;
            _selection = selection;
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
        public void GetObjectData(SerializationInfo info, StreamingContext context)
        {

            info.AddValue("Text", _text);
            info.AddValue("CursorPosition", _cursorPosition);
            info.AddValue("Selection", _selection);
        }
    }
}
