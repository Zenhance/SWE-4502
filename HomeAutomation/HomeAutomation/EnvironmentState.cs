using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    // Core/EnvironmentState.cs
    public class EnvironmentState
    {
        
        public Dictionary<string, object> State { get; set; } = new Dictionary<string, object>();

      
        public void PrintState()
        {
            Console.WriteLine("Environment State:");
            foreach (var key in State.Keys)
            {
                Console.WriteLine($"{key}: {State[key]}");
            }
        }
    }
}
