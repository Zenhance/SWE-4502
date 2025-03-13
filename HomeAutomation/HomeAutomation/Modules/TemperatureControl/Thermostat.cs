using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class Thermostat : IThermostat
    {
        private double _currentTemperature;
        private double _targetTemperature;
        private const double Hysteresis = 0.5; // Prevents rapid switching

        public void SetTargetTemperature(double temperature)
        {
            _targetTemperature = temperature;
            Console.WriteLine($"Target temperature set to {_targetTemperature}°C.");
        }

        public void UpdateCurrentTemperature(double temperature)
        {
            _currentTemperature = temperature;
            Console.WriteLine($"Current temperature updated to {_currentTemperature}°C.");
            ControlTemperature();
        }

        public void ControlTemperature()
        {
            if (_currentTemperature < _targetTemperature - Hysteresis)
            {
                Console.WriteLine("Heating ON.");
            }
            else if (_currentTemperature > _targetTemperature + Hysteresis)
            {
                Console.WriteLine("Cooling ON.");
            }
            else
            {
                Console.WriteLine("HVAC system is idle.");
            }
        }
    }
}
