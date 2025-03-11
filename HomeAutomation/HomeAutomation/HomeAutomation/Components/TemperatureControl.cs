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

         
        }
    }
}
