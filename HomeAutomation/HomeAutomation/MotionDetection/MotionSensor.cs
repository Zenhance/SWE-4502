using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class MotionSensor : IMotionSensor
    {
        private bool _motionDetected;
        private string _lastDetectedLocation;

        public void DetectMotion(string location)
        {
            _motionDetected = true;
            _lastDetectedLocation = location;
            Console.WriteLine($"Motion detected in {location} at {DateTime.Now}");
        }

        public bool IsMotionDetected()
        {
            return _motionDetected;
        }

        public void Reset()
        {
            _motionDetected = false;
            Console.WriteLine("Motion sensor reset.");
        }
    }
}
