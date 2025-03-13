using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace src
{
    public class MotionDetection : IObserver
    {
        private CoreComponent coreComponent;

        public MotionDetection(CoreComponent coreComponent)
        {
            this.coreComponent = coreComponent;
            coreComponent.RegisterObserver(this);
        }

        public void Update(string key, string value)
        {
            if (key == "motion")
            {
                LogMotion(value);
            }
        }

        public void LogMotion(string motionData)
        {
            Console.WriteLine($"Motion detected: {motionData}");
        }

        public void DetectMotion(string location, string time)
        {
            coreComponent.SetState("motion", $"{location} at {time}");
        }

        public void AnalyzePatterns()
        {
            Console.WriteLine("Analyzing motion patterns...");
        }
    }
}
