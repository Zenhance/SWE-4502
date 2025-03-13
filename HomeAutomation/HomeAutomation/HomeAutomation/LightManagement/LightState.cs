using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class LightState
    {
        public bool IsRoomTaken {get;set;}
        public int AmbientLight { get; set; }

        public LightState(bool istaken,int ambientlight) 
        {
            IsRoomTaken = istaken;
            AmbientLight = ambientlight;
        }
    }
}
