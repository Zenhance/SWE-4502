using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyHomeAutomation
{
    public class MotionDetection : IObserver
    {
        private CoreSystem coreSystem;

        public MotionDetection(CoreSystem coreSystem)
        {
            this.coreSystem = coreSystem;
            coreSystem.RegisterObserver(this);
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
            coreSystem.SetState("motion", $"{location} at {time}");
        }

        public void AnalyzePatterns()
        {
            Console.WriteLine("Analyzing motion patterns...");
        }
    }
}
