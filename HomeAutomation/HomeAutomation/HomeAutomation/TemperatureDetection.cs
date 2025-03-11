using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class TemperatureDetection:IObserver
    {
        public void Notify(Environment env)
        {
            Console.WriteLine($"Current Temperature is: {env.Temperature}");
        }
    }
}
