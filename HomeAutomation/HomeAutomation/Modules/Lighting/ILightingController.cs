using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public interface ILightingController
    {
        void TurnOn();
        void TurnOff();
        void AdjustBrightness(int level);
    }
}
