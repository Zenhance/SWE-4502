using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Components
{
    public abstract class VoiceCommandHandler
    {
        protected VoiceCommandHandler _nextHandler;

        public void SetNext(VoiceCommandHandler next)
        {
            _nextHandler = next;
        }

        // Returns a response if the command is handled, otherwise passes it along.
        public virtual string HandleCommand(string command)
        {
            if (_nextHandler != null)
                return _nextHandler.HandleCommand(command);
            else
                return "Command not recognized.";
        }
    }
}
