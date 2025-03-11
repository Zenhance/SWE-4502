using HomeAutomation.Core_Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Components
{
     public class LightManagment : IObserver
    {
        public bool LightOn { get; set; } = false;

        public void Update(CentralState state)
        {
            LightOn = state.LightLevel< 50;
        }
    }
}
