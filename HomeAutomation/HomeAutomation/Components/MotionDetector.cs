using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HomeAutomation.Core;

namespace HomeAutomation.Components
{
    public class MotionDetector : IComponent
    {
        public bool MotionDetected { get; private set; }
        public DateTime LastMotionTime { get; private set; }
        public string LastLocation { get; private set; }

        public void OnStateChanged(EnvironmentalState state)
        {
            if (state.MotionDetected)
            {
                MotionDetected = true;
                LastMotionTime = DateTime.Now;
                LastLocation = "Hallway";
            }
            else
            {
                MotionDetected = false;
            }
        }
    }
}
