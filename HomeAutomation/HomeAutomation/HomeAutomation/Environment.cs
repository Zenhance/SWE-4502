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

    }
}
