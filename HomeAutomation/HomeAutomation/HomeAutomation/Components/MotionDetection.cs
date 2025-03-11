using HomeAutomation.Core_Model;
using System;

namespace HomeAutomation.Components
{
    public class MotionDetection : IObserver
    {
        private bool motionDetected;
        private long lastDetectedTime;
        
        
        public void Update(CentralState state)
        {
            bool newMotionDetected = state.MotionDetected;


            if(newMotionDetected && !motionDetected )
            {
                motionDetected = true;
                lastDetectedTime = DateTimeOffset.Now.ToUnixTimeMilliseconds();
                
            }
            else if (!state.MotionDetected && motionDetected) 
            {
                motionDetected = false;
            }
        }
    }
}
