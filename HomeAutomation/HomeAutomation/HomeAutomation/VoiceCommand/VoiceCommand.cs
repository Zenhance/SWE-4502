using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class VoiceCommand : IObserver
    {
        public IVoice ivoice { get; set; }
        public void Notify(EnvironmentalState state)
        {
            if (state.isMotionDetected)
            {
                ivoice = new LightOn();
            }
            else
            {
                ivoice = new LightOff();
            }

            ivoice.Execute();
        }
    }
}
