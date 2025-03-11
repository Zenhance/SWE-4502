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
        public int LightLevel { get; set; }
        public int ChangeLightLevel { get; set; }
        public bool RoomOccupied { get; set; }
        public String Scene { get; set; }

        public void Update(CentralState state)
        {
            LightLevel = state.LightLevel;
            RoomOccupied = state.RoomOccupied;

            if(!RoomOccupied)
            {
                ChangeLightLevel = 0;
                Scene = "Off";
            }
            else
            {
                if(LightLevel < 50)
                {
                    ChangeLightLevel = 50;
                    Scene = "Low";
                }
                else if (LightLevel >= 50 && LightLevel < 100)
                {
                    ChangeLightLevel = 100;
                    Scene = "Medium";
                }
                else
                {
                    ChangeLightLevel = 100;
                    Scene = "High";
                }
            }
            Console.WriteLine($"Light Level: {LightLevel} Change Light Level: {ChangeLightLevel} Scene: {Scene}");
        }

        public int GetChangedLightLevel()
        {
            return ChangeLightLevel;
        }

        public String GetScene()
        {
            return Scene;
        }
    }
}
