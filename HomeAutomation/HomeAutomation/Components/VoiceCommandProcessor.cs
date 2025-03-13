using HomeAutomation.Core;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HomeAutomation.Core;


namespace HomeAutomation.Components
{
    public class VoiceCommandProcessor : IComponent
    {
        public List<string> CommandHistory { get; private set; } = new List<string>();
        private VoiceCommandHandler _handlerChain;

        public VoiceCommandProcessor()
        {
          
            var lightHandler = new LightCommandHandler();
            var temperatureHandler = new TemperatureCommandHandler();
            var defaultHandler = new DefaultCommandHandler();

            lightHandler.SetNext(temperatureHandler);
            temperatureHandler.SetNext(defaultHandler);

            _handlerChain = lightHandler;
        }

        public string ProcessCommand(string command)
        {
            CommandHistory.Add(command);
            return _handlerChain.HandleCommand(command);
        }

       
        public void OnStateChanged(EnvironmentalState state)
        {
            
            
        }
    }
}
