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
        public bool isMotionDetected { get; set; }
        public double Temperature { get; set; }

        public string Location { get; set; }

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

        public void UpdateHomeEnvironment(bool detected,double temp, string location)
        {
            detected = isMotionDetected;
            Temperature = temp;
            Location = location;

            foreach (var subscriber in subscribers)
            {
                subscriber.Notify(this);
            }
        }
    }
}
