using System;
using HomeAutomation.Core_Model;

namespace HomeAutomation.Components
{
     public class TemperatureControl : IObserver
    {
        public double CurrentTemperature { get; set; }
        public double DesiredTemperature { get; set; }
        public string Mode { get; set; }= "Idle";
        public bool RoomOccupied { get; set; }


        public void Update(CentralState state)
        {
            CurrentTemperature = state.Temperature;
            RoomOccupied = state.RoomOccupied;
            AdjustTemperature();

        }
        private void AdjustTemperature()
        {
            if (!RoomOccupied)
            {
                // Save energy when room is unoccupied
                DesiredTemperature = 25.0; // Default energy-saving mode
                Mode = "Idle";
            }
            else
            {
                if (CurrentTemperature < 18)
                {
                    DesiredTemperature = 22; // Increase temperature for comfort
                    Mode = "Heating";
                }
                else if (CurrentTemperature > 26)
                {
                    DesiredTemperature = 22; // Decrease temperature for comfort
                    Mode = "Cooling";
                }
                else
                {
                    DesiredTemperature = CurrentTemperature; // Maintain current temperature
                    Mode = "Idle";
                }
            }

            Console.WriteLine($"Temperature Adjusted: Mode - {Mode}, Desired Temperature - {DesiredTemperature}°C");
        }

        public double GetDesiredTemperature()
        {
            return DesiredTemperature;
        }

        public string GetMode()
        {
            return Mode;
        }

    }
}
