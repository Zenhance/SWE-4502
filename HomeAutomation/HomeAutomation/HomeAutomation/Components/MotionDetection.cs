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
                LogMotion();
            }
            else if (!state.MotionDetected && motionDetected) 
            {
                motionDetected = false;
            }
        }

        private void LogMotion()
        {
            Console.WriteLine( $"Motion detected at {DateTimeOffset.FromUnixTimeMilliseconds(lastDetectedTime)}");
        }

        
    }
}
