using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class Environment
    {
        public List<IObserver> subscribers = new List<IObserver> ();
        public bool isMotionDetected { get; set; }
        public double Temperature { get; set; }

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

        public void UpdateHomeEnvironment(bool detected,double temp)
        {
            detected = isMotionDetected;
            Temperature = temp;

            foreach (var subscriber in subscribers)
            {
                subscriber.Notify(this);
            }
        }
    }
}
