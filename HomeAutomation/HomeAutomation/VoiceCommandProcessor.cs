using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class VoiceCommandProcessor : IStateChangeListener
    {
        public VoiceCommandProcessor()
        {
            StateChangeNotifier.Instance.Subscribe(this);
        }

        public void ProcessCommand(IVoiceCommand command)
        {
            command.Execute();
        }

        public void OnStateChange(EnvironmentState state)
        {
            
        }
    }
}
