using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class StateChangeNotifier
    {
        private static readonly StateChangeNotifier _instance = new StateChangeNotifier();
        private List<IStateChangeListener> _listeners = new List<IStateChangeListener>();

        private StateChangeNotifier() { } 
        public static StateChangeNotifier Instance => _instance;

        public void Subscribe(IStateChangeListener listener)
        {
            _listeners.Add(listener);
        }

        public void Notify(EnvironmentState state)
        {
            foreach (var listener in _listeners)
            {
                listener.OnStateChange(state);
            }
        }
    }
}
