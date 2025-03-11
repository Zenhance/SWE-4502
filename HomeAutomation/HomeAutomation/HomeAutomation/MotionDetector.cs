using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class MotionDetector:IObserver
    {
        public void Notify(Environment env)
        {
            if (env.isMotionDetected)
            {
                Console.WriteLine("Motion Detected!");
            }
            else
            {
                Console.WriteLine("No motion detected.");
            }
        }

    }
}
