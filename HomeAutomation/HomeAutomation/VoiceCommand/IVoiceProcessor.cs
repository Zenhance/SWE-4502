using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public interface IVoiceProcessor
    {
        void ProcessCommand(string command);
        string GetLastCommand();
    }
}
