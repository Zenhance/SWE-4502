using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Core
{
    public class EnvironmentState
    {
        public bool MotionDetected { get; set; }
        public int AmbientLight { get; set; }
        public double Temperature { get; set; }
        public double PowerUsage { get; set; }
    }

}
