using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class StateManager : IStateSubject
    {
        private readonly List<IStateObserver> _observers = new List<IStateObserver>();
        private EnvironmentalState _currentState = new EnvironmentalState();

        public void RegisterObserver(IStateObserver observer)
        {
            _observers.Add(observer);
        }

        public void RemoveObserver(IStateObserver observer)
        {
            _observers.Remove(observer);
        }

        public void NotifyObservers()
        {
            foreach (var observer in _observers)
            {
                observer.Update(_currentState);
            }
        }

        public void UpdateState(EnvironmentalState newState)
        {
            _currentState = newState;
            NotifyObservers();
        }
    }
}
