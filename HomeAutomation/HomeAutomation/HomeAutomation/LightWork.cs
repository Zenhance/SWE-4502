using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class LightWork:Light
    {
        public override void Manage(LightState state)
        {
            if (state.IsRoomTaken)
            {
                Console.WriteLine("Adjusting light for occupied room.");
            }
            else if (state.AmbientLight < 50)
            {
                Console.WriteLine("Ambient light too low : increasing light.");
            }
            else
            {
                Console.WriteLine("No adjustent needed : perfect.");
            }

            light?.Manage(state);
        }
    }
}
