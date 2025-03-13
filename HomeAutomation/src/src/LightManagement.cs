using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace src
{
    public class LightManagement : IObserver
    {
        private CoreComponent coreComponent;

        public LightManagement(CoreComponent coreComponent)
        {
            this.coreComponent = coreComponent;
            coreComponent.RegisterObserver(this);
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
            coreComponent.SetState("light", scene);
        }

        public void CheckOccupancy()
        {
            Console.WriteLine("Checking room occupancy...");
        }
    }
}
