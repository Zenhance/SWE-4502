using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HomeAutomation.Core_Model;

namespace HomeAutomation.Components
{
    public class EnergyConsumtion:IObserver
    {
        public void Update(CentralState state)
        {
            if (state.RoomOccupied)
            {
                Console.WriteLine("Energy Consumption: 1000W");
            }
            else
            {
                Console.WriteLine("Energy Consumption: 0W");
            }
        }
    }
}
