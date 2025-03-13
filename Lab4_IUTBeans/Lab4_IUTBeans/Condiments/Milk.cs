using Lab4_IUTBeans;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab4_IUTBeans
{
    public class Milk : ICondiment
    {
        public string GetCondimentDescription()
        {
            return "Milk";
        }

        public double GetCondimentCost()
        {
            return 50;
        }
    }
}


