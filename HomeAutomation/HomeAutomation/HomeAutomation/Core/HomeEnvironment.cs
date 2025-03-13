using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class HomeEnvironment
    {
        public List<IObserver> subscribers = new List<IObserver> ();
        public EnvironmentalState CurrentState { get; set; }

        public void Subscribe(IObserver subscriber)
        {
            if(!subscribers.Contains(subscriber))
            {
                subscribers.Add(subscriber);
            }
        }

        public void Unsubscribe(IObserver subscriber)
        {
            subscribers.Remove(subscriber);
        }

        public void UpdateHomeEnvironment(bool detected, double temp, string location)
        {
            CurrentState = new EnvironmentalState
            {
                isMotionDetected = detected,
                Temperature = temp,
                Location = location
            };

            NotifySubscribers();
        }

        public void NotifySubscribers()
        {
            foreach (var subscriber in subscribers)
            {
                subscriber.Notify(CurrentState);
            }
        }
    }
}
