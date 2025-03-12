using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class EnvironmentalState
    {
        public double Temperature { get; set; }
        public double AmbientLight { get; set; }
        public bool MotionDetected { get; set; }
    }
}
