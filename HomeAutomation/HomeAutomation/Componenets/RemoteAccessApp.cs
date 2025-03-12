using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HomeAutomation.Core;

namespace HomeAutomation.Componenets
{
    public class RemoteAccessApp : IEnvironmentObserver
    {
        public void OnEnvironmentStateChanged(EnvironmentState state)
        {
            Console.WriteLine($"Remote App Update: Motion: {state.MotionDetected}, Light: {state.AmbientLight}, Temp: {state.Temperature}");
        }
    }

}
