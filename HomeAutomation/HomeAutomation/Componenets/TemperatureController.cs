using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HomeAutomation.Core;

namespace HomeAutomation.Componenets
{
    public class TemperatureController : IEnvironmentObserver
    {
        private const double Hysteresis = 1.0; // Prevents frequent switching
        private double targetTemperature = 22.0;
        public string HvacState { get; private set; } = "OFF";

        public void OnEnvironmentStateChanged(EnvironmentState state)
        {
            if (state.Temperature < targetTemperature - Hysteresis)
            {
                HvacState = "HEATING";
            }
            else if (state.Temperature > targetTemperature + Hysteresis)
            {
                HvacState = "COOLING";
            }
            else
            {
                HvacState = "OFF";
            }

            Console.WriteLine($"HVAC State: {HvacState}");
        }

        public void SetTargetTemperature(double temperature)
        {
            targetTemperature = temperature;
        }
    }

}
