using HomeAutomation.Core_Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Components
{
    public class MotionDetection : IObserver
    {
        private bool motionDetected;
        public List<bool> MotionLog { get; set; } = new List<bool>();
        public void Update(CentralState state)
        {
            bool newMotionDetected = state.MotionDetected;


            if(newMotionDetected && !motionDetected )
            {
                motionDetected = true;
                
            }
        }
    }
}
