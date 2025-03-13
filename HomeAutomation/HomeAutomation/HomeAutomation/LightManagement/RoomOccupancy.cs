using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class RoomOccupancy:Light
    {
        public override void Manage(LightState state)
        {
            if (state.IsRoomTaken)
            {
                Console.WriteLine("Turning lights on.");
            }
            else
            {
                Console.WriteLine("Room is empty, lights off.");
            }

            light?.Manage(state);
        }
    }
}
