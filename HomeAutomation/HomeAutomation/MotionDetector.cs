using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
   
    public class MotionDetector : IMotionDetector, IStateChangeListener
    {
        public MotionDetector()
        {
            StateChangeNotifier.Instance.Subscribe(this);
        }

        public void DetectMotion(string location, DateTime time)
        {
            var state = new EnvironmentState();
            state.State["MotionLocation"] = location;
            state.State["MotionTime"] = time;
            StateChangeNotifier.Instance.Notify(state);
        }

        public void OnStateChange(EnvironmentState state)
        {
           
        }
    }
}
