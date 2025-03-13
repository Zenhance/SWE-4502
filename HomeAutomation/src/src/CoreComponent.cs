using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace src
{
    public class CoreComponent
    {
        private List<IObserver> observers;
        private Dictionary<string, string> state;

        public CoreComponent()
        {
            observers = new List<IObserver>();
            state = new Dictionary<string, string>();
        }

        public void RegisterObserver(IObserver observer)
        {
            observers.Add(observer);
        }

        public void UnregisterObserver(IObserver observer)
        {
            observers.Remove(observer);
        }

        public void NotifyObservers(string key)
        {
            foreach (var observer in observers)
            {
                observer.Update(key, state[key]);
            }
        }

    }
}
