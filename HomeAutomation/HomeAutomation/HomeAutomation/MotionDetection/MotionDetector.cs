using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class MotionDetector:IObserver
    {

        public List<string> detectionLogs = new List<string>();
        public void Notify(EnvironmentalState state)
        {
            if (state.isMotionDetected)
            {
                var LogDetected = $"Motion detected at {DateTime.Now} in {state.Location}";
                detectionLogs.Add(LogDetected);
                Console.WriteLine(LogDetected);
            }
            else
            {
                Console.WriteLine("No motion detected.");
            }
        }

    }
}
