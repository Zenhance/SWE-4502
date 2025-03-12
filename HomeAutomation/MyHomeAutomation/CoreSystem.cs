using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyHomeAutomation
{
    public class CoreSystem
    {
        private List<IObserver> observers;
        private Dictionary<string, string> state;

        public CoreSystem() 
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

        public void SetState(string key, string value)
        {
            state[key] = value;
            NotifyObservers(key);
        }

        public string GetState(string key)
        {
            if(state.ContainsKey(key)) return state[key];
            throw new Exception("Key not found!");
        }
    }
}
