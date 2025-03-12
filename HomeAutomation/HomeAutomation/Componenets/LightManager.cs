using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HomeAutomation.Core;

namespace HomeAutomation.Componenets
{
    public class LightManager : IEnvironmentObserver
    {
        public bool IsLightOn { get; private set; }

        public void OnEnvironmentStateChanged(EnvironmentState state)
        {
            if (state.AmbientLight < 20) // Low light condition
            {
                IsLightOn = true;
            }
            else
            {
                IsLightOn = false;
            }

            Console.WriteLine($"Light is {(IsLightOn ? "ON" : "OFF")}");
        }
    }

}
