using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Core
{
    public class EnvironmentMonitor
    {
        private List<IEnvironmentObserver> observers = new();

        public void RegisterObserver(IEnvironmentObserver observer)
        {
            observers.Add(observer);
        }

        public void NotifyObservers(EnvironmentState state)
        {
            foreach (var observer in observers)
            {
                observer.OnEnvironmentStateChanged(state);
            }
        }
    }
}
