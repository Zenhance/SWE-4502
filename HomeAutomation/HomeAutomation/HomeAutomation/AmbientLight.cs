using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class AmbientLight:Light
    {
        public override void Manage(LightState state)
        {
            if (state.AmbientLight < 50)
            {
                Console.WriteLine("Ambient light too low : increasing light.");
            }
            else
            {
                Console.WriteLine("No adjustment needed : perfect");
            }

            light?.Manage(state);
        }
    }
}
