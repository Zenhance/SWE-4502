using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class TemperatureControl:IObserver
    {
        public double TargetTemp;
        public ITemp heat;
        public ITemp cool;

        public TemperatureControl(double targetTemperature)
        {
            this.TargetTemp = targetTemperature;
            this.heat = new HeatCommand();
            this.cool = new CoolCommand();
        }
        public void Notify(HomeEnvironment env)
        {
            if (env.Temperature < TargetTemp)
            {
                heat.Do();
            }
            else if (env.Temperature > TargetTemp)
            {
                cool.Do();
            }
            else
            {
                Console.WriteLine("Temperature is stable.");
            }
        }
    }
}
