using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public interface IThermostat
    {
        void SetTargetTemperature(double temperature);
        void UpdateCurrentTemperature(double temperature);
        void ControlTemperature();
    }
}
