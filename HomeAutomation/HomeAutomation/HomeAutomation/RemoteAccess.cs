using System;
using System.Collections.Generic;
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
        public void Notify(HomeEnvironment env)
        {
            Console.WriteLine($"Motion Detected : {env.isMotionDetected}, {env.Temperature}, in {env.Location}");
        }

        public void ControlSystem(bool motionDetected)
        {
            homeenv.UpdateHomeEnvironment(motionDetected, homeenv.Temperature, homeenv.Location);
        }
    }
}
