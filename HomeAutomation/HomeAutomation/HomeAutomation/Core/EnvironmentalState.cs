using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class EnvironmentalState
    {
        public bool isMotionDetected { get; set; }
        public double Temperature { get; set; }

        public string Location { get; set; }
    }
}
