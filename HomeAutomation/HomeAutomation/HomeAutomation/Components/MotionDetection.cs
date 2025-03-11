using HomeAutomation.Core_Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Components
{
    public class MotionDetection : IObserver
    {

        public List<bool> MotionLog { get; set; } = new List<bool>();
        public void Update(CentralState state)
        {
            MotionLog.Add(state.MotionDetected);
        }
    }
}
