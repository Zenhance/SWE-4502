using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HomeAutomation.Core;

namespace HomeAutomation.Components
{
    public class TemperatureController : IComponent
    {
        public double CurrentTemperature { get; private set; }
        public double TargetTemperature { get; private set; }
        public bool HeatingOn { get; private set; }
        public bool CoolingOn { get; private set; }
        private const double Hysteresis = 0.5;

        public TemperatureController(double targetTemperature)
        {
            TargetTemperature = targetTemperature;
        }

        public void OnStateChanged(EnvironmentalState state)
        {
            CurrentTemperature = state.Temperature;
            if (CurrentTemperature < TargetTemperature - Hysteresis)
            {
                HeatingOn = true;
                CoolingOn = false;
            }
            else if (CurrentTemperature > TargetTemperature + Hysteresis)
            {
                CoolingOn = true;
                HeatingOn = false;
            }
            else
            {
                HeatingOn = false;
                CoolingOn = false;
            }
        }
    }
}
