using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace taskManager
{
    public interface metadata
    {
        string description { get; set; }
        DateTime timestamp { get; set; }

    }
}
