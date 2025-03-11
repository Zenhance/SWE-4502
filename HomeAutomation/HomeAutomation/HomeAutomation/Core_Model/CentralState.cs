using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Core_Model
{
    public  class CentralState
    {
        public bool MotionDetected { get; set; }
        public int LightLevel { get; set; }
        public bool RoomOccupied { get; set; }
        public int Temperature { get; set; }
        public double EnergyUsage { get; set; }
        public string VoiceCommand { get; set; }
    }
}
