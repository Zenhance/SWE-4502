using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public static class MotionDetectorFactory
    {
        public static IMotionDetector CreateMotionDetector()
        {
            return new MotionDetector();
        }
    }
}
