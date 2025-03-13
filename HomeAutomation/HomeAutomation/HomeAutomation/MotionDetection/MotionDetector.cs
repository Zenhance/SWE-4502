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
        public void Notify(HomeEnvironment env)
        {
            if (env.isMotionDetected)
            {
                var LogDetected = $"Motion detected at {DateTime.Now} in {env.Location}";
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
