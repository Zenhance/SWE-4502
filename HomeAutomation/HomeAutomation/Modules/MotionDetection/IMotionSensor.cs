using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public interface IMotionSensor
    {
        void DetectMotion(string location);
        bool IsMotionDetected();
    }
}
