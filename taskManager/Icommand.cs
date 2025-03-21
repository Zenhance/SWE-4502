using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace taskManager
{
    public interface Icommand
    {
        void Undo();
        void Redo();

    }
}
