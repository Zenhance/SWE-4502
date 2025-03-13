using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class LightingController : ILightingController
    {
        private int _brightness;
        private bool _isOn;

        public void TurnOn()
        {
            _isOn = true;
            Console.WriteLine("Lights turned ON.");
        }

        public void TurnOff()
        {
            _isOn = false;
            Console.WriteLine("Lights turned OFF.");
        }

        public void AdjustBrightness(int level)
        {
            if (!_isOn)
            {
                Console.WriteLine("Cannot adjust brightness. Lights are OFF.");
                return;
            }

            _brightness = Math.Clamp(level, 0, 100);
            Console.WriteLine($"Brightness set to {_brightness}%.");
        }
    }
}
