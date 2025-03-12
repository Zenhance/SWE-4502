using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HomeAutomation.Core;

namespace HomeAutomation.Componenets
{
    public class MotionDetector : IEnvironmentObserver
    {
        private List<string> motionLog = new();

        public void OnEnvironmentStateChanged(EnvironmentState state)
        {
            if (state.MotionDetected)
            {
                string logEntry = $"Motion detected at {DateTime.Now}";
                motionLog.Add(logEntry);
                Console.WriteLine(logEntry);
            }
        }

        public List<string> GetMotionLogs()
        {
            return motionLog;
        }
    }
}
