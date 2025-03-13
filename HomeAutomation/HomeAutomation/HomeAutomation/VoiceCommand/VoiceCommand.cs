using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class VoiceCommand : IObserver
    {
        public IVoice ivoice;
        public void Notify(HomeEnvironment env)
        {
            if (env.isMotionDetected)
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
