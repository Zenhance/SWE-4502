using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class RemoteAccess:IObserver
    {
        public HomeEnvironment homeenv; 
        public RemoteAccess(HomeEnvironment env)
        {
            this.homeenv = env;
            
        }
        public void Notify(EnvironmentalState state)
        {
            Console.WriteLine($"Motion Detected: {state.isMotionDetected}, Temperature: {state.Temperature}, Location: {state.Location}");
        }

        public void ControlSystem(bool motionDetected)
        {
            homeenv.UpdateHomeEnvironment(motionDetected, homeenv.CurrentState.Temperature, homeenv.CurrentState.Location);
        }
    }
}
