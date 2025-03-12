using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class RoomLightControl
    {
        public Light handler;
        public RoomLightControl()
        {
            handler = new RoomOccupancy();
            var ambientlight = new AmbientLight();
            handler.Setlight(ambientlight);
        }

        public void AdjustLight(LightState state)
        {
            handler.Manage(state);
        }
    }
}
