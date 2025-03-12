using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
   
    public class Thermostat : IStateChangeListener
    {
        private static readonly Thermostat _instance = new Thermostat();

        private Thermostat()
        {
            StateChangeNotifier.Instance.Subscribe(this);
        }

        public static Thermostat Instance => _instance;

        public void AdjustTemperature(float currentTemp, float targetTemp)
        {
            var state = new EnvironmentState();
            state.State["CurrentTemperature"] = currentTemp;
            state.State["TargetTemperature"] = targetTemp;
            StateChangeNotifier.Instance.Notify(state);
        }

        public void OnStateChange(EnvironmentState state)
        {
           
          
        }
    }
}
