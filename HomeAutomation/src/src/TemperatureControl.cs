using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace src
{
    public class TemperatureControl : IObserver
    {
        private CoreComponent coreComponent;

        public TemperatureControl(CoreComponent coreComponent)
        {
            this.coreComponent = coreComponent;
            coreComponent.RegisterObserver(this);
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
            coreComponent.SetState("temperature", target);
        }

        public void PreventRapidCycling()
        {
            Console.WriteLine("Preventing rapid HVAC cycling...");
        }
    }
}
