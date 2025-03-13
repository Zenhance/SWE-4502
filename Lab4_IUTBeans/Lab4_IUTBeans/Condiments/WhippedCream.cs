using Lab4_IUTBeans;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab4_IUTBeans
{
    public class WhippedCream : ICondiment
    {
        public string GetCondimentDescription()
        {
            return "Whipped Cream";
        }

        public double GetCondimentCost()
        {
            return 25;
        }
    }
}


