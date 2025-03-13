using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Core
{
    public class EnvironmentalState : ICloneable
    {
        public double Temperature { get; set; }
        public double AmbientLight { get; set; }
        public bool MotionDetected { get; set; }

        public object Clone()
        {
           
            return new EnvironmentalState
            {
                Temperature = this.Temperature,
                AmbientLight = this.AmbientLight,
                MotionDetected = this.MotionDetected
            };
        }
    }
}
