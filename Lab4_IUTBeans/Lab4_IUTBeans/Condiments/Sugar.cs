using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab4_IUTBeans
{
    public class Sugar : ICondiment
    {
        public string GetCondimentDescription()
        {
            return "Sugar";
        }

        public double GetCondimentCost()
        {
            return 25;
        }
    }
}
