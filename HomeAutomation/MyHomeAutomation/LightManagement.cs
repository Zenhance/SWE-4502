using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyHomeAutomation
{
    public class LightManagement : IObserver
    {
        private CoreSystem coreSystem;

        public LightManagement(CoreSystem coreSystem)
        {
            this.coreSystem = coreSystem;
            coreSystem.RegisterObserver(this);
        }

        public void Update(string key, string value)
        {
            if (key == "light")
            {
                AdjustLighting(value);
            }
        }

        public void AdjustLighting(string lightLevel)
        {
            Console.WriteLine($"Adjusting lighting to: {lightLevel}");
        }

        public void SetScene(string scene)
        {
            coreSystem.SetState("light", scene);
        }

        public void CheckOccupancy()
        {
            Console.WriteLine("Checking room occupancy...");
        }
    }
}
