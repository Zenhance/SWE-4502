using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public interface IMotionDetector
    {
        void DetectMotion(string location, DateTime time);
    }
}
