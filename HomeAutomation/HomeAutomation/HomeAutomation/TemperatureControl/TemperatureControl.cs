using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Policy;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class TemperatureControl:IObserver
    {
        public double TargetTemp;
        public ITemp heat;
        public ITemp cool;
        public double LastTemp;

        public TemperatureControl(double targetTemperature)
        {
            this.TargetTemp = targetTemperature;
            this.heat = new HeatCommand();
            this.cool = new CoolCommand();
            this.LastTemp = targetTemperature;
        }
        public void Notify(EnvironmentalState state)
        {
            if (Math.Abs(state.Temperature - LastTemp) > 12.0) // Hysteresis threshold
            {
                if (state.Temperature < TargetTemp)
                {
                    heat.Do();
                }
                else if (state.Temperature > TargetTemp)
                {
                    cool.Do();
                }
                else
                {
                    Console.WriteLine("Temperature is stable.");
                }

                LastTemp = state.Temperature;
            }
        }
    }
}
