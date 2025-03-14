using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Security.Permissions;
using System.Text;
using System.Threading.Tasks;

namespace Lab12
{
    [Serializable]
     public class EditorMemento : ISerializable
    {
        public string Text { get; private set; }
        public int CursorPosition { get; private set; }
        public string Selection { get; private set; }
        protected EditorMemento(SerializationInfo info, StreamingContext context)
        {
            Text = info.GetString("Text");
            CursorPosition = info.GetInt32("CursorPosition");
            Selection = info.GetString("Selection");
        }

        [SecurityPermission(SecurityAction.Demand, SerializationFormatter = true)]
        public void GetObjectData(SerializationInfo info, StreamingContext context)
        {
            info.AddValue("Text", Text);
            info.AddValue("CursorPosition", CursorPosition);
            info.AddValue("Selection", Selection);
        }


     }
}
