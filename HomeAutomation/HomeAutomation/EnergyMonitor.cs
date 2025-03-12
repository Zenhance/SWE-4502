using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class EnergyMonitor : IStateChangeListener
    {
        public EnergyMonitor()
        {
            StateChangeNotifier.Instance.Subscribe(this);
        }

        public void TrackConsumption(float powerUsage)
        {
            var state = new EnvironmentState();
            state.State["PowerUsage"] = powerUsage;
            StateChangeNotifier.Instance.Notify(state);
        }

        public void OnStateChange(EnvironmentState state)
        {
            if (state.State.ContainsKey("PowerUsage"))
            {
                Console.WriteLine($"Energy Monitor: Power Usage = {state.State["PowerUsage"]} Watts");
            }
        }
    }
}
