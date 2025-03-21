using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace labfinal_210042111
{
    public interface Command
    {
        void Execute();
        void undo();
    }
}
