using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public abstract class Light
    {
        protected Light light;
        public void Setlight(Light lightt)
        {
            light = lightt;
        }
        public abstract void Manage(LightState state);
    }
}
