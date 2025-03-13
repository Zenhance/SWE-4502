using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class EnvironmentalState
    {
        public bool MotionDetected { get; set; }
        public double Temperature { get; set; }
        public double AmbientLightLevel { get; set; }
        public double EnergyUsage { get; set; }

        public override string ToString()
        {
            return $"Motion: {MotionDetected}, Temp: {Temperature}°C, Light: {AmbientLightLevel} lux, Power: {EnergyUsage}W";
        }
    }
}
