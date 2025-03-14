using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Lab12
{
    [Serializable]
     public class EditorMemento : ISerializable
    {
        protected EditorMemento(SerializationInfo info, StreamingContext context)
        {
            
        }
    }
}
