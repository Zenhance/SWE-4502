using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class TemperatureControl : IObserver
    {
        private CoreSystem coreSystem;

        public TemperatureControl(CoreSystem coreSystem)
        {
            this.coreSystem = coreSystem;
            coreSystem.RegisterObserver(this);
        }

        public void Update(string key, string value)
        {
            if (key == "temperature")
            {
                AdjustTemperature(value);
            }
        }

        public void AdjustTemperature(string temperature)
        {
            Console.WriteLine($"Adjusting temperature to: {temperature}");
        }

        public void SetTargetTemperature(string target)
        {
            coreSystem.SetState("temperature", target);
        }

        public void PreventRapidCycling()
        {
            Console.WriteLine("Preventing rapid HVAC cycling...");
        }
    }
}
