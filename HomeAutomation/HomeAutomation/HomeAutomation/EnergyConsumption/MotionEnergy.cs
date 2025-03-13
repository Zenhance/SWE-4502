using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class MotionEnergy : EnergyChain
    {
        public double totalConsumption = 0;

        public override void Manager(HomeEnvironment env)
        {
            if (env.isMotionDetected)
            {
                double consumption = 12.12;
                totalConsumption += consumption;
                Console.WriteLine($"Energy Consumption Updated: {consumption} watts. Total: {totalConsumption} watts.");

                if (totalConsumption > 1212.12)
                {
                    Console.WriteLine("Warning: Unusual energy consumption detected!");
                }
            }

            chain?.Manager(env);
        }
    }
}
